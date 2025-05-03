package com.example.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    @Autowired
    private NinjaRepository ninjaRepository;

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }

    @PostMapping
    public ResponseEntity<NinjaModel> criarNinja(@RequestBody NinjaModel ninja){
        NinjaModel novoNinja = ninjaRepository.save(ninja);
        return ResponseEntity.ok(novoNinja);
    }

    @GetMapping
    public ResponseEntity<List<NinjaModel>> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaModel> buscarPorId(@PathVariable Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NinjaModel> atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel atualizacao) {
        return ninjaRepository.findById(id).map(ninja -> {
            ninja.setNome(atualizacao.getNome());
            ninja.setEmail(atualizacao.getEmail());
            ninja.setIdade(atualizacao.getIdade());
            ninja.setMissoes(atualizacao.getMissoes());
            return ResponseEntity.ok(ninjaRepository.save(ninja));
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNinja(@PathVariable Long id) {
        if (ninjaRepository.existsById(id)) {
            ninjaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

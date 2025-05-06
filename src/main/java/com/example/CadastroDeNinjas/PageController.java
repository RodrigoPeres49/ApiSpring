package com.example.CadastroDeNinjas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller

public class PageController {

    @GetMapping("/principal")
    public String mostrarPaginaPrincipal(Model model) { // ERRO se Model não for importado ou usado
        return "principal";
    }

}

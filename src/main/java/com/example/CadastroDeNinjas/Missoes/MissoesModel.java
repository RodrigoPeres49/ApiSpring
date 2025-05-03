package com.example.CadastroDeNinjas.Missoes;

import com.example.CadastroDeNinjas.Ninjas.NinjaModel;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy =  "missoes")
    private List<NinjaModel> ninjas;


}

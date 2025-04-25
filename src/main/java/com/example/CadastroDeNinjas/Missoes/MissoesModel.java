package com.example.CadastroDeNinjas.Missoes;

import com.example.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")


public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String dificuldade;
    private NinjaModel ninja;


}

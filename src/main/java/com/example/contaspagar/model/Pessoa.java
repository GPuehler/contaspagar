package com.example.contaspagar.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoPessoa;

    @Column(name = "nome")
    private String nome;

    public Pessoa() {

    }

    public long getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

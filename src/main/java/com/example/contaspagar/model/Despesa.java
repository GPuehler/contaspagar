package com.example.contaspagar.model;

import javax.persistence.*;

@Entity
@Table(name = "despesa")
public class Despesa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoDespesa;

    public long getCodigoDespesa() {
        return codigoDespesa;
    }

    public void setCodigoDespesa(long codigoDespesa) {
        this.codigoDespesa = codigoDespesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "nome")
    private String nome;
}

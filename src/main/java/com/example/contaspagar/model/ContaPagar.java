package com.example.contaspagar.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conta")
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoConta;

    @Column(name = "data_emissao")
    private Date dataEmissao;

    @Column(name = "data_vencimento")
    private Date dataVencimento;

    @Column(name = "valor")
    private double valor;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Despesa despesa;

    @Column(name = "data_pagamento")
    private Date dataPagamento;



    public long getCodigo() {
        return codigoConta;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
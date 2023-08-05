package com.example.precofipeapp.api.model;

import java.io.Serializable;

public class Marcas implements Serializable {

    private String nome;
    private int codigo;

    public Marcas(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

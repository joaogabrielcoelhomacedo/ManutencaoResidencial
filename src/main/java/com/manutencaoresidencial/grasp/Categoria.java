package com.manutencaoresidencial.grasp;

import java.util.List;
import java.util.ArrayList;

// GRASP: Information Expert - sabe listar os próprios profissionais vinculados
public class Categoria {
    private int idCategoria;
    private String nome;
    private List<Profissional> profissionais = new ArrayList<>();

    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    public List<Profissional> listarProfissionais() {
        return profissionais;
    }

    public int getIdCategoria() { return idCategoria; }
    public String getNome() { return nome; }
}

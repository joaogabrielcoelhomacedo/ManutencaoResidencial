package com.manutencaoresidencial.grasp;

// GRASP: Information Expert - sabe a própria experiência declarada pelo profissional
public class Especialidade {
    private int idEspecialidade;
    private int idProfissional;
    private int idCategoria;
    private String experiencia;

    public Especialidade(int idEspecialidade, int idProfissional, int idCategoria, String experiencia) {
        this.idEspecialidade = idEspecialidade;
        this.idProfissional = idProfissional;
        this.idCategoria = idCategoria;
        this.experiencia = experiencia;
    }

    public String getExperiencia() { return experiencia; }
}

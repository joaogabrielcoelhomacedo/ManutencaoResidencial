package com.manutencaoresidencial.solid;

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

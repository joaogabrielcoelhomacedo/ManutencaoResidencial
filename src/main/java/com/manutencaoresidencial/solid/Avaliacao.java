package com.manutencaoresidencial.solid;

// SOLID: SRP - guarda os dados da avaliação; o recálculo de média fica no AvaliacaoService
public class Avaliacao {
    private int idAvaliacao;
    private int idExecucao;
    private int idCliente;
    private int idProfissional;
    private int nota;
    private String comentario;

    public Avaliacao(int idAvaliacao, int idExecucao, int idCliente, int idProfissional, int nota, String comentario) {
        this.idAvaliacao = idAvaliacao;
        this.idExecucao = idExecucao;
        this.idCliente = idCliente;
        this.idProfissional = idProfissional;
        this.nota = nota;
        this.comentario = comentario;
    }

    public void denunciar() { }
    public int getNota() { return nota; }
    public int getIdProfissional() { return idProfissional; }
}

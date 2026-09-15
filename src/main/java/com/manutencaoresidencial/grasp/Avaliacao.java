package com.manutencaoresidencial.grasp;

// GRASP: Information Expert - concentra nota/comentário e sabe calcular a própria média
public class Avaliacao {
    private int idAvaliacao;
    private int idExecucao;
    private int idCliente;
    private int idProfissional;
    private int nota;
    private String comentario;

    public Avaliacao(int idAvaliacao, int idExecucao, int idCliente, int idProfissional,
                      int nota, String comentario) {
        this.idAvaliacao = idAvaliacao;
        this.idExecucao = idExecucao;
        this.idCliente = idCliente;
        this.idProfissional = idProfissional;
        this.nota = nota;
        this.comentario = comentario;
    }

    public double calcularMedia() {
        return nota;
    }

    public void denunciar() {
        // marca a avaliação para análise do PainelAdministrativo
    }
}

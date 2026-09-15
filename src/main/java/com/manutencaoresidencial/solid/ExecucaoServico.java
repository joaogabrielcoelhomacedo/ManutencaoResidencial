package com.manutencaoresidencial.solid;

public class ExecucaoServico {
    private int idExecucao;
    private int idAgendamento;
    private String status;

    public ExecucaoServico(int idExecucao, int idAgendamento) {
        this.idExecucao = idExecucao;
        this.idAgendamento = idAgendamento;
        this.status = "NAO_INICIADO";
    }

    public void iniciarServico() { this.status = "EM_ANDAMENTO"; }
    public void finalizarServico() { this.status = "FINALIZADO"; }

    public int getIdExecucao() { return idExecucao; }
}

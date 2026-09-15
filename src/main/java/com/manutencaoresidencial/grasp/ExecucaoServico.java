package com.manutencaoresidencial.grasp;

import java.util.ArrayList;
import java.util.List;

// GRASP: Creator + Controller - criada a partir de um Agendamento confirmado, controla o ciclo da execução
public class ExecucaoServico {
    private int idExecucao;
    private int idAgendamento;
    private String dataInicio;
    private String dataFim;
    private String observacoes;
    private List<String> fotosServico = new ArrayList<>();
    private String status;

    public ExecucaoServico(int idExecucao, int idAgendamento) {
        this.idExecucao = idExecucao;
        this.idAgendamento = idAgendamento;
        this.status = "NAO_INICIADO";
    }

    public void iniciarServico() { this.status = "EM_ANDAMENTO"; }
    public void atualizarStatus(String status) { this.status = status; }
    public void finalizarServico() { this.status = "FINALIZADO"; }
    public void confirmarConclusao() { this.status = "CONCLUIDO"; }

    public int getIdExecucao() { return idExecucao; }
    public int getIdAgendamento() { return idAgendamento; }
}

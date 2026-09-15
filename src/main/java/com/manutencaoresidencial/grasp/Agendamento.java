package com.manutencaoresidencial.grasp;

// GRASP: Creator + Controller - criado a partir de um Orcamento aceito e recebe as operações de agenda
public class Agendamento {
    private int idAgendamento;
    private int idOrcamento;
    private String dataHora;
    private String status;

    public Agendamento(int idAgendamento, int idOrcamento, String dataHora) {
        this.idAgendamento = idAgendamento;
        this.idOrcamento = idOrcamento;
        this.dataHora = dataHora;
        this.status = "PENDENTE";
    }

    public void confirmar() { this.status = "CONFIRMADO"; }
    public void reagendar(String novaData) { this.dataHora = novaData; }
    public void cancelar() { this.status = "CANCELADO"; }
    public void enviarLembrete() { }

    public int getIdAgendamento() { return idAgendamento; }
    public int getIdOrcamento() { return idOrcamento; }
}

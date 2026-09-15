package com.manutencaoresidencial.solid;

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

    public int getIdAgendamento() { return idAgendamento; }
}

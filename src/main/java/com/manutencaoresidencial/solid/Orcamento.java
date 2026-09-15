package com.manutencaoresidencial.solid;

// SOLID: SRP - só guarda dados e status do orçamento
public class Orcamento {
    private int idOrcamento;
    private int idSolicitacao;
    private int idProfissional;
    private double valor;
    private String status;

    public Orcamento(int idOrcamento, int idSolicitacao, int idProfissional, double valor) {
        this.idOrcamento = idOrcamento;
        this.idSolicitacao = idSolicitacao;
        this.idProfissional = idProfissional;
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public void aceitar() { this.status = "ACEITO"; }
    public void recusar() { this.status = "RECUSADO"; }
    public String consultarStatus() { return status; }

    public int getIdOrcamento() { return idOrcamento; }
    public int getIdProfissional() { return idProfissional; }
    public double getValor() { return valor; }
}

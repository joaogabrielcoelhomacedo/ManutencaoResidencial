package com.manutencaoresidencial.grasp;

// GRASP: Information Expert - concentra os dados e o status do próprio orçamento
public class Orcamento {
    private int idOrcamento;
    private int idSolicitacao;
    private int idProfissional;
    private double valor;
    private String materiaisInclusos;
    private String prazoEstimado;
    private String status;

    public Orcamento(int idOrcamento, int idSolicitacao, int idProfissional, double valor, String status) {
        this.idOrcamento = idOrcamento;
        this.idSolicitacao = idSolicitacao;
        this.idProfissional = idProfissional;
        this.valor = valor;
        this.status = status;
    }

    public void aceitar() { this.status = "ACEITO"; }
    public void recusar() { this.status = "RECUSADO"; }
    public void solicitarAlteracao() { this.status = "ALTERACAO_SOLICITADA"; }
    public String consultarStatus() { return status; }

    public int getIdOrcamento() { return idOrcamento; }
    public int getIdSolicitacao() { return idSolicitacao; }
    public int getIdProfissional() { return idProfissional; }
    public double getValor() { return valor; }
}

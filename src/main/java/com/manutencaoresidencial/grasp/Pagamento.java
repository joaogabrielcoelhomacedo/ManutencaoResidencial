package com.manutencaoresidencial.grasp;

// GRASP: Low Coupling - só depende de GatewayPagamento (interface), não da execução em si
public class Pagamento {
    private int idPagamento;
    private int idExecucao;
    private double valorFinal;
    private String formaPagamento;
    private String statusPagamento;
    private String dataPagamento;

    public Pagamento(int idPagamento, int idExecucao, double valorFinal, String formaPagamento) {
        this.idPagamento = idPagamento;
        this.idExecucao = idExecucao;
        this.valorFinal = valorFinal;
        this.formaPagamento = formaPagamento;
        this.statusPagamento = "PENDENTE";
    }

    public boolean registrarPagamento() {
        this.statusPagamento = "PAGO";
        return true;
    }

    public String consultarStatus() { return statusPagamento; }
}

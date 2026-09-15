package com.manutencaoresidencial.solid;

// SOLID: DIP - o gateway é injetado no construtor (abstração GatewayPagamento), a classe
// Pagamento não cria nem conhece GatewayPagamentoExterno diretamente
public class Pagamento {
    private int idPagamento;
    private int idExecucao;
    private double valorFinal;
    private String statusPagamento;
    private final GatewayPagamento gateway;

    public Pagamento(int idPagamento, int idExecucao, double valorFinal, GatewayPagamento gateway) {
        this.idPagamento = idPagamento;
        this.idExecucao = idExecucao;
        this.valorFinal = valorFinal;
        this.gateway = gateway;
        this.statusPagamento = "PENDENTE";
    }

    public boolean registrarPagamento(String forma) {
        boolean sucesso = gateway.processarPagamento(valorFinal, forma);
        this.statusPagamento = sucesso ? "PAGO" : "FALHOU";
        return sucesso;
    }

    public String consultarStatus() { return statusPagamento; }
}

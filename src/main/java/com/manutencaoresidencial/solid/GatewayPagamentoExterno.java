package com.manutencaoresidencial.solid;

public class GatewayPagamentoExterno implements GatewayPagamento {
    private String provedor;

    public GatewayPagamentoExterno(String provedor) {
        this.provedor = provedor;
    }

    @Override
    public boolean processarPagamento(double valor, String forma) {
        return true;
    }
}

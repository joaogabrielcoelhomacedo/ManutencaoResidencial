package com.manutencaoresidencial.grasp;

// GRASP: Polymorphism - implementação concreta de GatewayPagamento para um provedor externo
public class GatewayPagamentoExterno implements GatewayPagamento {
    private String provedor;

    public GatewayPagamentoExterno(String provedor) {
        this.provedor = provedor;
    }

    @Override
    public boolean processarPagamento(double valor, String forma) {
        // integração com o provedor externo (ex: Stripe, PagSeguro...)
        return true;
    }
}

package com.manutencaoresidencial.grasp;

// GRASP: Protected Variations - isola o sistema da variação do provedor de pagamento
public interface GatewayPagamento {
    boolean processarPagamento(double valor, String forma);
}

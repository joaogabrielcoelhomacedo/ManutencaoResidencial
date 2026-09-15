package com.manutencaoresidencial.solid;

// SOLID: OCP + DIP - novos provedores entram como classe nova; quem processa pagamento
// depende só desta abstração
public interface GatewayPagamento {
    boolean processarPagamento(double valor, String forma);
}

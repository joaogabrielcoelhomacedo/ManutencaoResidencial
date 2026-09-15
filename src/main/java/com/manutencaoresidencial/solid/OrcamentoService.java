package com.manutencaoresidencial.solid;

// SOLID: SRP - responsável só pela regra de negócio de criar orçamento, separado da entidade Orcamento
public class OrcamentoService {
    private int proximoId = 1;

    public Orcamento enviarOrcamento(SolicitacaoServico solicitacao, Profissional profissional, double valor) {
        return new Orcamento(proximoId++, solicitacao.getIdSolicitacao(), profissional.getIdUsuario(), valor);
    }
}

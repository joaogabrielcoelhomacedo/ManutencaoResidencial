package com.manutencaoresidencial.solid;

import java.util.List;

// SOLID: SRP + DIP - responsabilidade única de consultar o histórico, dependendo da
// abstração Repositorio<SolicitacaoServico>, não de uma implementação específica
public class Historico {
    private final Repositorio<SolicitacaoServico> repositorioSolicitacao;

    public Historico(Repositorio<SolicitacaoServico> repositorioSolicitacao) {
        this.repositorioSolicitacao = repositorioSolicitacao;
    }

    public List<SolicitacaoServico> listarSolicitacoes(int idUsuario) {
        return repositorioSolicitacao.listarPorUsuario(idUsuario);
    }
}

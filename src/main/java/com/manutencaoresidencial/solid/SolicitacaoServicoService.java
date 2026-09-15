package com.manutencaoresidencial.solid;

// SOLID: SRP + DIP - concentra o caso de uso "criar solicitação" e depende da abstração Repositorio<T>,
// não de uma implementação concreta de persistência
public class SolicitacaoServicoService {
    private final Repositorio<SolicitacaoServico> repositorio;
    private int proximoId = 1;

    public SolicitacaoServicoService(Repositorio<SolicitacaoServico> repositorio) {
        this.repositorio = repositorio;
    }

    public SolicitacaoServico criar(int idCliente, int idCategoria) {
        SolicitacaoServico solicitacao = new SolicitacaoServico(proximoId++, idCliente, idCategoria, 0, "");
        repositorio.salvar(solicitacao);
        return solicitacao;
    }
}

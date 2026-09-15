package com.manutencaoresidencial.grasp;

import java.util.List;
import java.util.ArrayList;

// GRASP: Pure Fabrication - classe artificial que consulta os repositórios, sem sujar Cliente/Profissional
public class Historico {
    private int idHistorico;
    private int idUsuario;
    private RepositorioSolicitacao repositorioSolicitacao = new RepositorioSolicitacao();

    public Historico(int idHistorico, int idUsuario) {
        this.idHistorico = idHistorico;
        this.idUsuario = idUsuario;
    }

    public List<SolicitacaoServico> listarSolicitacoes(int idUsuario) {
        return repositorioSolicitacao.listarPorUsuario(idUsuario);
    }

    public List<Orcamento> listarOrcamentos(int idUsuario) { return new ArrayList<>(); }
    public List<Agendamento> listarAgendamentos(int idUsuario) { return new ArrayList<>(); }
    public List<ExecucaoServico> listarExecucoes(int idUsuario) { return new ArrayList<>(); }
    public List<Pagamento> listarPagamentos(int idUsuario) { return new ArrayList<>(); }
    public List<Avaliacao> listarAvaliacoes(int idUsuario) { return new ArrayList<>(); }
}

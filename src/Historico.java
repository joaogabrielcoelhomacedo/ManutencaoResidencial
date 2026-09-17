import java.util.ArrayList;
import java.util.List;

public class Historico {

    private int idHistorico;
    private int idUsuario;

    private final Repositorio<SolicitacaoServico> repositorioSolicitacao;

    private final List<Orcamento> orcamentos = new ArrayList<>();
    private final List<Agendamento> agendamentos = new ArrayList<>();
    private final List<ExecucaoServico> execucoes = new ArrayList<>();
    private final List<Pagamento> pagamentos = new ArrayList<>();
    private final List<Avaliacao> avaliacoes = new ArrayList<>();

    public Historico(Repositorio<SolicitacaoServico> repositorioSolicitacao) {
        this.repositorioSolicitacao = repositorioSolicitacao;
    }

    public void registrar(Orcamento orcamento) {
        orcamentos.add(orcamento);
    }

    public void registrar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public void registrar(ExecucaoServico execucao) {
        execucoes.add(execucao);
    }

    public void registrar(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void registrar(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<SolicitacaoServico> listarSolicitacoes(int idUsuario) {
        return repositorioSolicitacao.listarPorUsuario(idUsuario);
    }

    public List<Orcamento> listarOrcamentos(int idUsuario) {
        List<Orcamento> resultado = new ArrayList<>();

        for (Orcamento orcamento : orcamentos) {
            if (orcamento.getIdProfissional() == idUsuario) {
                resultado.add(orcamento);
            }
        }

        return resultado;
    }

    public List<Agendamento> listarAgendamentos(int idUsuario) {
        List<Agendamento> resultado = new ArrayList<>();

        for (Agendamento agendamento : agendamentos) {
            for (Orcamento orcamento : listarOrcamentos(idUsuario)) {
                if (agendamento.getIdOrcamento() == orcamento.getIdOrcamento()) {
                    resultado.add(agendamento);
                }
            }
        }

        return resultado;
    }

    public List<ExecucaoServico> listarExecucoes(int idUsuario) {
        List<ExecucaoServico> resultado = new ArrayList<>();

        for (ExecucaoServico execucao : execucoes) {
            for (Agendamento agendamento : listarAgendamentos(idUsuario)) {
                if (execucao.getIdAgendamento() == agendamento.getIdAgendamento()) {
                    resultado.add(execucao);
                }
            }
        }

        return resultado;
    }

    public List<Pagamento> listarPagamentos(int idUsuario) {
        List<Pagamento> resultado = new ArrayList<>();

        for (Pagamento pagamento : pagamentos) {
            for (ExecucaoServico execucao : listarExecucoes(idUsuario)) {
                if (pagamento.getIdExecucao() == execucao.getIdExecucao()) {
                    resultado.add(pagamento);
                }
            }
        }

        return resultado;
    }

    public List<Avaliacao> listarAvaliacoes(int idUsuario) {
        List<Avaliacao> resultado = new ArrayList<>();

        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getIdCliente() == idUsuario || avaliacao.getIdProfissional() == idUsuario) {
                resultado.add(avaliacao);
            }
        }

        return resultado;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

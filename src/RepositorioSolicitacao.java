import java.util.ArrayList;
import java.util.List;

public class RepositorioSolicitacao implements Repositorio<SolicitacaoServico> {

    private final List<SolicitacaoServico> solicitacoes = new ArrayList<>();

    @Override
    public void salvar(SolicitacaoServico entidade) {
        solicitacoes.add(entidade);
    }

    @Override
    public List<SolicitacaoServico> listarPorUsuario(int idUsuario) {
        List<SolicitacaoServico> resultado = new ArrayList<>();

        for (SolicitacaoServico solicitacao : solicitacoes) {
            if (solicitacao.getIdCliente() == idUsuario) {
                resultado.add(solicitacao);
            }
        }

        return resultado;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Profissional extends Usuario implements Avaliavel {

    private String descricao;
    private String regiaoAtendimento;
    private double mediaAvaliacao;

    private final List<Especialidade> especialidades = new ArrayList<>();
    private final List<Disponibilidade> disponibilidades = new ArrayList<>();
    private final List<Avaliacao> avaliacoes = new ArrayList<>();

    public Profissional() {
    }

    public Profissional(int idUsuario, String nome, String email, String senha,
                        String telefone, String regiaoAtendimento) {

        super(idUsuario, nome, email, senha, telefone);
        this.regiaoAtendimento = regiaoAtendimento;
    }

    @Override
    public String perfil() {
        return "PROFISSIONAL";
    }

    @Override
    public double getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    @Override
    public void receberAvaliacao(int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdProfissional(this.idUsuario);
        avaliacao.setNota(nota);
        avaliacao.setComentario(comentario);
        avaliacoes.add(avaliacao);

        double soma = 0;
        for (Avaliacao registrada : avaliacoes) {
            soma += registrada.getNota();
        }
        this.mediaAvaliacao = soma / avaliacoes.size();
    }

    public void adicionarEspecialidade(Categoria categoria, String experiencia) {
        Especialidade especialidade = new Especialidade();
        especialidade.setProfissional(this);
        especialidade.setIdCategoria(categoria.getIdCategoria());
        especialidade.setExperiencia(experiencia);
        especialidades.add(especialidade);
        categoria.adicionarEspecialidade(especialidade);
    }

    public void definirDisponibilidade(Disponibilidade disponibilidade) {
        disponibilidade.setIdProfissional(this.idUsuario);
        disponibilidades.add(disponibilidade);
    }

    public Orcamento enviarOrcamento(SolicitacaoServico solicitacao, double valor) {
        Orcamento orcamento = new Orcamento();
        orcamento.setIdSolicitacao(solicitacao.getIdSolicitacao());
        orcamento.setIdProfissional(this.idUsuario);
        orcamento.setValor(valor);
        solicitacao.atualizarStatus("ORCADA");
        return orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRegiaoAtendimento() {
        return regiaoAtendimento;
    }

    public void setRegiaoAtendimento(String regiaoAtendimento) {
        this.regiaoAtendimento = regiaoAtendimento;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public List<Disponibilidade> getDisponibilidades() {
        return disponibilidades;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}

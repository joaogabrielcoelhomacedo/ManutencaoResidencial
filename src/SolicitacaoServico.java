import java.util.ArrayList;
import java.util.List;

public class SolicitacaoServico {

    private int idSolicitacao;
    private int idCliente;
    private int idCategoria;
    private int idEndereco;
    private String descricao;
    private final List<String> fotos = new ArrayList<>();
    private final List<String> videos = new ArrayList<>();
    private String urgencia;
    private String periodoPreferido;
    private String status;

    public SolicitacaoServico() {
        this.status = "ABERTA";
    }

    public SolicitacaoServico(int idSolicitacao, int idCliente, int idCategoria,
                              int idEndereco, String descricao, String urgencia) {

        this.idSolicitacao = idSolicitacao;
        this.idCliente = idCliente;
        this.idCategoria = idCategoria;
        this.idEndereco = idEndereco;
        this.descricao = descricao;
        this.urgencia = urgencia;
        this.status = "ABERTA";
    }

    public void cancelar() {
        this.status = "CANCELADA";
    }

    public String consultarStatus() {
        return status;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public List<String> getVideos() {
        return videos;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getPeriodoPreferido() {
        return periodoPreferido;
    }

    public void setPeriodoPreferido(String periodoPreferido) {
        this.periodoPreferido = periodoPreferido;
    }
}

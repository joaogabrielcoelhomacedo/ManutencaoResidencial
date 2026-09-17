public class Denuncia {

    private int idDenuncia;
    private int idAvaliacao;
    private int idUsuario;
    private String motivo;
    private String status;
    private String data;

    public Denuncia() {
        this.status = "PENDENTE";
    }

    public Denuncia(int idDenuncia, int idAvaliacao, int idUsuario, String motivo, String data) {
        this.idDenuncia = idDenuncia;
        this.idAvaliacao = idAvaliacao;
        this.idUsuario = idUsuario;
        this.motivo = motivo;
        this.data = data;
        this.status = "PENDENTE";
    }

    public void analisar() {
        this.status = "EM_ANALISE";
    }

    public void arquivar() {
        this.status = "ARQUIVADA";
    }

    public String consultarStatus() {
        return status;
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

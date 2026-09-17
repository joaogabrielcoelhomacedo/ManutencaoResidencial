public class Avaliacao {

    private int idAvaliacao;
    private int idExecucao;
    private int idCliente;
    private int idProfissional;
    private int nota;
    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(int idAvaliacao, int idExecucao, int idCliente,
                     int idProfissional, int nota, String comentario) {

        this.idAvaliacao = idAvaliacao;
        this.idExecucao = idExecucao;
        this.idCliente = idCliente;
        this.idProfissional = idProfissional;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Denuncia denunciar(String motivo) {
        Denuncia denuncia = new Denuncia();
        denuncia.setIdAvaliacao(this.idAvaliacao);
        denuncia.setIdUsuario(this.idProfissional);
        denuncia.setMotivo(motivo);
        return denuncia;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdExecucao() {
        return idExecucao;
    }

    public void setIdExecucao(int idExecucao) {
        this.idExecucao = idExecucao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

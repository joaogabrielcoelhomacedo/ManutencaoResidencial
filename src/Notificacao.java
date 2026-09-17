public class Notificacao {

    private int idNotificacao;
    private int idUsuario;
    private String tipo;
    private String mensagem;
    private boolean lida;
    private String data;

    private final CanalNotificacao canal;

    public Notificacao(CanalNotificacao canal) {
        this.canal = canal;
    }

    public Notificacao(int idNotificacao, int idUsuario, String tipo,
                       String mensagem, String data, CanalNotificacao canal) {

        this.idNotificacao = idNotificacao;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.data = data;
        this.canal = canal;
        this.lida = false;
    }

    public void enviar(Usuario destinatario) {
        canal.enviar(mensagem, destinatario);
    }

    public void marcarComoLida() {
        this.lida = true;
    }

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isLida() {
        return lida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

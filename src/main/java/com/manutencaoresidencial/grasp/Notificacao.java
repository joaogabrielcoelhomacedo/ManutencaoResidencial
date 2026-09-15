package com.manutencaoresidencial.grasp;

// GRASP: Low Coupling - depende apenas do necessário para representar e enviar uma notificação
public class Notificacao {
    private int idNotificacao;
    private int idUsuario;
    private String tipo;
    private String mensagem;
    private boolean lida;
    private String data;

    public Notificacao(int idNotificacao, int idUsuario, String tipo, String mensagem, String data) {
        this.idNotificacao = idNotificacao;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.data = data;
        this.lida = false;
    }

    public void enviar() {
        // dispara o envio pelo canal apropriado
    }

    public void marcarComoLida() {
        this.lida = true;
    }

    public boolean isLida() { return lida; }
    public String getMensagem() { return mensagem; }
}

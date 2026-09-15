package com.manutencaoresidencial.solid;

// SOLID: SRP - guarda só o dado da notificação; o envio em si é responsabilidade do NotificacaoService
public class Notificacao {
    private int idNotificacao;
    private int idUsuario;
    private String tipo;
    private String mensagem;
    private boolean lida;

    public Notificacao(int idNotificacao, int idUsuario, String tipo, String mensagem) {
        this.idNotificacao = idNotificacao;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.lida = false;
    }

    public void marcarComoLida() { this.lida = true; }
    public String getMensagem() { return mensagem; }
}

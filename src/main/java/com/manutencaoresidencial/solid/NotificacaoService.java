package com.manutencaoresidencial.solid;

// SOLID: SRP + DIP - responsável só por "enviar notificações", e depende da abstração CanalNotificacao,
// não de uma implementação concreta (Email, SMS...). O canal é injetado no construtor.
public class NotificacaoService {
    private final CanalNotificacao canal;

    public NotificacaoService(CanalNotificacao canal) {
        this.canal = canal;
    }

    public void enviar(Notificacao notificacao, String destinatario) {
        canal.enviar(notificacao.getMensagem(), destinatario);
    }
}

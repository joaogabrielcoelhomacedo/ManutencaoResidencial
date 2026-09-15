package com.manutencaoresidencial.solid;

// SOLID: OCP - exemplo de extensão: canal novo adicionado sem tocar em CanalNotificacao,
// NotificadorEmail ou no NotificacaoService que os consome
public class NotificadorSms implements CanalNotificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        System.out.println("SMS para " + destinatario + ": " + mensagem);
    }
}

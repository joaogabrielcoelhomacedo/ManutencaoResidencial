package com.manutencaoresidencial.solid;

public class NotificadorEmail implements CanalNotificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        System.out.println("E-mail para " + destinatario + ": " + mensagem);
    }
}

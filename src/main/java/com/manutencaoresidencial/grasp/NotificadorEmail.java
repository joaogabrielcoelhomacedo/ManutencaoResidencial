package com.manutencaoresidencial.grasp;

// GRASP: Polymorphism - uma das implementações possíveis de CanalNotificacao
public class NotificadorEmail implements CanalNotificacao {
    @Override
    public void enviar(String mensagem, String destinatario) {
        // integração com serviço de e-mail
        System.out.println("E-mail para " + destinatario + ": " + mensagem);
    }
}

package com.manutencaoresidencial.grasp;

// GRASP: Protected Variations - protege o sistema contra variação do canal de envio (email, sms, push...)
public interface CanalNotificacao {
    void enviar(String mensagem, String destinatario);
}

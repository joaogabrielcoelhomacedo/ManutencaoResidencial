package com.manutencaoresidencial.solid;

// SOLID: OCP (Open/Closed) - novos canais são adicionados criando uma nova classe, sem alterar
// quem já usa CanalNotificacao
public interface CanalNotificacao {
    void enviar(String mensagem, String destinatario);
}

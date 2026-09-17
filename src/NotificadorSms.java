public class NotificadorSms implements CanalNotificacao {

    @Override
    public void enviar(String mensagem, Usuario destinatario) {
        System.out.println("[SMS] para " + destinatario.getTelefone() + ": " + mensagem);
    }
}

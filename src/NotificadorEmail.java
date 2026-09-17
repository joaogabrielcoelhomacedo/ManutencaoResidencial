public class NotificadorEmail implements CanalNotificacao {

    @Override
    public void enviar(String mensagem, Usuario destinatario) {
        System.out.println("[E-MAIL] para " + destinatario.getEmail() + ": " + mensagem);
    }
}

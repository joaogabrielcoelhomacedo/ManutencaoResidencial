public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "ADMINISTRADOR";
    }
}

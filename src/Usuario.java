public abstract class Usuario {

    protected int idUsuario;
    protected String nome;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String fotoPerfil;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String email, String senha, String telefone) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public boolean cadastrar() {
        return nome != null && !nome.isEmpty()
                && email != null && email.contains("@")
                && senha != null && senha.length() >= 6;
    }

    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() {
        this.senha = null;
    }

    public void recuperarSenha(String email) {
        if (this.email.equals(email)) {
            this.senha = "temporaria";
        }
    }

    public void editarDados() {
        this.fotoPerfil = "atualizada";
    }

    public abstract String perfil();

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}

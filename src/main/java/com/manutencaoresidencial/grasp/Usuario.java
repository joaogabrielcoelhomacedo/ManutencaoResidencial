package com.manutencaoresidencial.grasp;

// GRASP: Polymorphism (base) - classe abstrata que varia por subtipo (Cliente, Profissional, Administrador)
public abstract class Usuario {
    protected int idUsuario;
    protected String nome;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String fotoPerfil;

    public Usuario(int idUsuario, String nome, String email, String senha, String telefone) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public boolean cadastrar() {
        // validação e persistência do novo usuário
        return true;
    }

    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() {
        // encerra sessão
    }

    public void recuperarSenha(String email) {
        // dispara fluxo de recuperação de senha
    }

    public void editarDados() {
        // atualiza dados cadastrais
    }

    public abstract String perfil();

    public int getIdUsuario() { return idUsuario; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
}

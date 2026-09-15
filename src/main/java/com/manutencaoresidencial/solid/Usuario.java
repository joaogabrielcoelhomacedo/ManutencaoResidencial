package com.manutencaoresidencial.solid;

// SOLID: LSP (Liskov Substitution) - qualquer subclasse (Cliente, Profissional, Administrador) pode
// substituir Usuario em qualquer lugar do sistema sem quebrar o comportamento esperado de perfil()
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

    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() { }
    public void editarDados() { }

    public abstract String perfil();

    public int getIdUsuario() { return idUsuario; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
}

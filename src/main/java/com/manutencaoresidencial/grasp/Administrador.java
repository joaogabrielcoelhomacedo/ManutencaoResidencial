package com.manutencaoresidencial.grasp;

// GRASP: Polymorphism - especialização de Usuario, mesma interface (perfil()) com comportamento próprio
public class Administrador extends Usuario {

    public Administrador(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "ADMINISTRADOR";
    }
}

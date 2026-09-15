package com.manutencaoresidencial.solid;

// SOLID: LSP - especializa Usuario sem alterar as pré-condições/pós-condições do contrato da superclasse
public class Administrador extends Usuario {

    public Administrador(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "ADMINISTRADOR";
    }
}

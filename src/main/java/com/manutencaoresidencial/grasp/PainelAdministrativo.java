package com.manutencaoresidencial.grasp;

// GRASP: Controller - recebe as operações administrativas do sistema e delega para as classes de domínio
public class PainelAdministrativo {
    private int idAdmin;
    private int idUsuario;

    public PainelAdministrativo(int idAdmin, int idUsuario) {
        this.idAdmin = idAdmin;
        this.idUsuario = idUsuario;
    }

    public void gerenciarClientes() { }
    public void gerenciarProfissionais() { }
    public void gerenciarCategorias() { }
    public void gerenciarServicos() { }
    public void bloquearUsuario(int id) { }
    public void analisarDenuncias() { }
    public void gerenciarAvaliacoes() { }
    public void verEstatisticas() { }
}

package com.manutencaoresidencial.solid;

// SOLID: ISP - em vez de uma única interface "gorda" com 8 métodos (como no diagrama original),
// o painel implementa 4 interfaces pequenas. Uma tela que só precisa moderar denúncias pode
// depender só de GerenciamentoModeracao, sem carregar os outros 6 métodos que não usa.
public class PainelAdministrativo implements GerenciamentoUsuarios, GerenciamentoCatalogo,
        GerenciamentoModeracao, Estatisticas {
    private int idAdmin;
    private int idUsuario;

    public PainelAdministrativo(int idAdmin, int idUsuario) {
        this.idAdmin = idAdmin;
        this.idUsuario = idUsuario;
    }

    @Override public void gerenciarClientes() { }
    @Override public void gerenciarProfissionais() { }
    @Override public void bloquearUsuario(int id) { }
    @Override public void gerenciarCategorias() { }
    @Override public void gerenciarServicos() { }
    @Override public void analisarDenuncias() { }
    @Override public void gerenciarAvaliacoes() { }
    @Override public void verEstatisticas() { }
}

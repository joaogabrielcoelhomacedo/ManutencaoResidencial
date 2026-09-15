package com.manutencaoresidencial.solid;

// SOLID: ISP (Interface Segregation) - quem só precisa gerenciar usuários não é forçado a
// depender de métodos de catálogo, moderação ou estatísticas
public interface GerenciamentoUsuarios {
    void gerenciarClientes();
    void gerenciarProfissionais();
    void bloquearUsuario(int id);
}

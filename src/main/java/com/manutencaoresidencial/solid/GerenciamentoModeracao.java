package com.manutencaoresidencial.solid;

// SOLID: ISP - interface enxuta, só com o que diz respeito a denúncias/avaliações
public interface GerenciamentoModeracao {
    void analisarDenuncias();
    void gerenciarAvaliacoes();
}

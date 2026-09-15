package com.manutencaoresidencial.grasp;

import java.util.List;
import java.util.ArrayList;

// GRASP: Controller + Pure Fabrication - classe artificial (não é conceito do domínio) criada
// só para coordenar a operação de busca, mantendo Categoria e Profissional coesos
public class BuscaProfissionais {
    private String termoBusca;

    public List<Profissional> buscar(FiltroBusca criterios) {
        List<Profissional> resultado = new ArrayList<>();
        return criterios.aplicar(resultado);
    }

    public String getTermoBusca() { return termoBusca; }
    public void setTermoBusca(String termoBusca) { this.termoBusca = termoBusca; }
}

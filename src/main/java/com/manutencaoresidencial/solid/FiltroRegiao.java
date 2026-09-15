package com.manutencaoresidencial.solid;

import java.util.List;
import java.util.stream.Collectors;

// SOLID: OCP - exemplo de extensão: novo filtro adicionado sem tocar em FiltroBusca,
// FiltroCategoria ou no serviço de busca
public class FiltroRegiao implements FiltroBusca {
    private String regiao;

    public FiltroRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public List<Profissional> aplicar(List<Profissional> profissionais) {
        return profissionais.stream()
                .filter(p -> regiao.equals(p.getRegiaoAtendimento()))
                .collect(Collectors.toList());
    }
}

package com.manutencaoresidencial.grasp;

import java.util.List;
import java.util.stream.Collectors;

// GRASP: Polymorphism - uma das implementações possíveis de FiltroBusca
public class FiltroCategoria implements FiltroBusca {
    private int idCategoria;

    public FiltroCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public List<Profissional> aplicar(List<Profissional> profissionais) {
        return profissionais; // filtragem por categoria seria aplicada aqui
    }
}

package com.manutencaoresidencial.solid;

import java.util.List;

public class FiltroCategoria implements FiltroBusca {
    private int idCategoria;

    public FiltroCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public List<Profissional> aplicar(List<Profissional> profissionais) {
        return profissionais;
    }
}

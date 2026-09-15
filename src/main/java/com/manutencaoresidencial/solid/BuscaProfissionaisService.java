package com.manutencaoresidencial.solid;

import java.util.List;
import java.util.ArrayList;

// SOLID: DIP - depende da abstração FiltroBusca, não de uma implementação concreta de filtro
public class BuscaProfissionaisService {
    public List<Profissional> buscar(List<Profissional> base, FiltroBusca criterio) {
        return criterio.aplicar(new ArrayList<>(base));
    }
}

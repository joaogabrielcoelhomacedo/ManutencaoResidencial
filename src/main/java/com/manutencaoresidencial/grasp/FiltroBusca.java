package com.manutencaoresidencial.grasp;

import java.util.List;

// GRASP: Protected Variations - protege BuscaProfissionais contra variação do critério de filtro
public interface FiltroBusca {
    List<Profissional> aplicar(List<Profissional> profissionais);
}

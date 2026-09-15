package com.manutencaoresidencial.solid;

import java.util.List;

// SOLID: OCP - novos critérios de busca entram como classe nova implementando esta interface,
// sem alterar BuscaProfissionaisService
public interface FiltroBusca {
    List<Profissional> aplicar(List<Profissional> profissionais);
}

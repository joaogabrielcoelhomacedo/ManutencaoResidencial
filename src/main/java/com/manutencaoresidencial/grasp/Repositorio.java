package com.manutencaoresidencial.grasp;

import java.util.List;

// GRASP: Protected Variations - isola quem persiste dados da variação da tecnologia de armazenamento
public interface Repositorio<T> {
    void salvar(T entidade);
    List<T> listarPorUsuario(int idUsuario);
}

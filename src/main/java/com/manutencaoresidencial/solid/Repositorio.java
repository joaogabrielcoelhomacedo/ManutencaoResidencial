package com.manutencaoresidencial.solid;

import java.util.List;

// SOLID: DIP - módulos de alto nível (services) dependem desta abstração, não de uma
// implementação concreta de banco de dados
public interface Repositorio<T> {
    void salvar(T entidade);
    List<T> listarPorUsuario(int idUsuario);
}

package com.manutencaoresidencial.grasp;

import java.util.ArrayList;
import java.util.List;

// GRASP: Polymorphism - implementação concreta de Repositorio<T> para SolicitacaoServico
public class RepositorioSolicitacao implements Repositorio<SolicitacaoServico> {
    private List<SolicitacaoServico> dados = new ArrayList<>();

    @Override
    public void salvar(SolicitacaoServico entidade) {
        dados.add(entidade);
    }

    @Override
    public List<SolicitacaoServico> listarPorUsuario(int idUsuario) {
        List<SolicitacaoServico> resultado = new ArrayList<>();
        for (SolicitacaoServico s : dados) {
            if (s.getIdCliente() == idUsuario) resultado.add(s);
        }
        return resultado;
    }
}

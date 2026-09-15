package com.manutencaoresidencial.solid;

import java.util.ArrayList;
import java.util.List;

// SOLID: OCP - uma nova forma de persistência (ex: banco relacional, NoSQL) entra como nova
// implementação de Repositorio<SolicitacaoServico>, sem alterar SolicitacaoServicoService
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

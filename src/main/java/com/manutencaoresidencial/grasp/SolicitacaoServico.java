package com.manutencaoresidencial.grasp;

import java.util.ArrayList;
import java.util.List;

// GRASP: Information Expert - concentra os dados e o próprio ciclo de status da solicitação
public class SolicitacaoServico {
    private int idSolicitacao;
    private int idCliente;
    private int idCategoria;
    private int idEndereco;
    private String descricao;
    private List<String> fotos = new ArrayList<>();
    private List<String> videos = new ArrayList<>();
    private String urgencia;
    private String periodoPreferido;
    private String status;

    public SolicitacaoServico(int idSolicitacao, int idCliente, int idCategoria, int idEndereco,
                               String descricao, String status) {
        this.idSolicitacao = idSolicitacao;
        this.idCliente = idCliente;
        this.idCategoria = idCategoria;
        this.idEndereco = idEndereco;
        this.descricao = descricao;
        this.status = status;
    }

    public void cancelar() {
        this.status = "CANCELADA";
    }

    public String consultarStatus() {
        return status;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public int getIdSolicitacao() { return idSolicitacao; }
    public int getIdCliente() { return idCliente; }
    public int getIdCategoria() { return idCategoria; }
}

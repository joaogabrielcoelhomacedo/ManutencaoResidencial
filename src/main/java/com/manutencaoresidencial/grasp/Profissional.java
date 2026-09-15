package com.manutencaoresidencial.grasp;

import java.util.ArrayList;
import java.util.List;

// GRASP: Creator + Information Expert - cria Orcamento e concentra os dados de avaliação/especialidade
public class Profissional extends Usuario implements Avaliavel {
    private String descricao;
    private String regiaoAtendimento;
    private double mediaAvaliacao;
    private List<Especialidade> especialidades = new ArrayList<>();
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    public Profissional(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "PROFISSIONAL";
    }

    @Override
    public double getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    @Override
    public void receberAvaliacao(int nota, String comentario) {
        // Profissional é quem tem o histórico de avaliações para recalcular a média
        mediaAvaliacao = (mediaAvaliacao + nota) / 2.0;
    }

    public void adicionarEspecialidade(Categoria categoria, String experiencia) {
        especialidades.add(new Especialidade(0, this.idUsuario, categoria.getIdCategoria(), experiencia));
    }

    public void definirDisponibilidade(Disponibilidade disponibilidade) {
        disponibilidades.add(disponibilidade);
    }

    public Orcamento enviarOrcamento(SolicitacaoServico solicitacao, double valor) {
        // Profissional é quem cria o Orcamento em resposta a uma solicitação
        return new Orcamento(0, solicitacao.getIdSolicitacao(), this.idUsuario, valor, "PENDENTE");
    }

    public String getRegiaoAtendimento() { return regiaoAtendimento; }
    public void setRegiaoAtendimento(String regiaoAtendimento) { this.regiaoAtendimento = regiaoAtendimento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}

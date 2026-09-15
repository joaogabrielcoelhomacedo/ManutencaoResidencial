package com.manutencaoresidencial.solid;

import java.util.ArrayList;
import java.util.List;

// SOLID: SRP - a classe cuida só dos dados/identidade do profissional; cálculo de média e envio de
// orçamento ficam em services dedicados (AvaliacaoService, OrcamentoService)
public class Profissional extends Usuario {
    private String descricao;
    private String regiaoAtendimento;
    private List<Especialidade> especialidades = new ArrayList<>();
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    public Profissional(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "PROFISSIONAL";
    }

    public void adicionarEspecialidade(Especialidade especialidade) {
        especialidades.add(especialidade);
    }

    public void definirDisponibilidade(Disponibilidade disponibilidade) {
        disponibilidades.add(disponibilidade);
    }

    public String getRegiaoAtendimento() { return regiaoAtendimento; }
    public void setRegiaoAtendimento(String r) { this.regiaoAtendimento = r; }
}

package com.manutencaoresidencial.solid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// SOLID: SRP - toda a regra de "calcular média de um profissional" fica isolada aqui,
// em vez de espalhada entre Profissional e Avaliacao
public class AvaliacaoService {
    private final Map<Integer, List<Avaliacao>> avaliacoesPorProfissional = new HashMap<>();

    public void registrar(Avaliacao avaliacao) {
        avaliacoesPorProfissional
            .computeIfAbsent(avaliacao.getIdProfissional(), k -> new ArrayList<>())
            .add(avaliacao);
    }

    public double calcularMedia(int idProfissional) {
        List<Avaliacao> avaliacoes = avaliacoesPorProfissional.getOrDefault(idProfissional, new ArrayList<>());
        if (avaliacoes.isEmpty()) return 0.0;
        double soma = 0;
        for (Avaliacao a : avaliacoes) soma += a.getNota();
        return soma / avaliacoes.size();
    }
}

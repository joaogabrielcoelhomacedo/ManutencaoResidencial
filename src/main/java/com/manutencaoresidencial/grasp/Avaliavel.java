package com.manutencaoresidencial.grasp;

// GRASP: Protected Variations - isola quem depende de "receber avaliação" da implementação concreta (Profissional)
public interface Avaliavel {
    void receberAvaliacao(int nota, String comentario);
    double getMediaAvaliacao();
}

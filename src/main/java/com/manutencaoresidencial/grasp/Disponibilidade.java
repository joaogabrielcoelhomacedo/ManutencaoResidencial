package com.manutencaoresidencial.grasp;

// GRASP: Information Expert - só a própria disponibilidade sabe verificar conflito de horário
public class Disponibilidade {
    private int idDisponibilidade;
    private int idProfissional;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;

    public Disponibilidade(int idDisponibilidade, int idProfissional, String diaSemana,
                            String horaInicio, String horaFim) {
        this.idDisponibilidade = idDisponibilidade;
        this.idProfissional = idProfissional;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public boolean verificarConflito(String dataHora) {
        // compara dataHora com a janela diaSemana/horaInicio/horaFim
        return false;
    }
}

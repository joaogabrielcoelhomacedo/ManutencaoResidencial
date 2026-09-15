package com.manutencaoresidencial.solid;

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
        return false;
    }
}

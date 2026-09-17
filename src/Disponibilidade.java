public class Disponibilidade {

    private int idDisponibilidade;
    private int idProfissional;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;

    public Disponibilidade() {
    }

    public Disponibilidade(int idDisponibilidade, String diaSemana, String horaInicio, String horaFim) {
        this.idDisponibilidade = idDisponibilidade;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public boolean verificarConflito(String dataHora) {
        if (dataHora == null || !dataHora.contains(" ")) {
            return false;
        }

        String[] partes = dataHora.split(" ");
        String dia = partes[0];
        String hora = partes[1];

        return dia.equalsIgnoreCase(diaSemana)
                && hora.compareTo(horaInicio) >= 0
                && hora.compareTo(horaFim) <= 0;
    }

    public int getIdDisponibilidade() {
        return idDisponibilidade;
    }

    public void setIdDisponibilidade(int idDisponibilidade) {
        this.idDisponibilidade = idDisponibilidade;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
}

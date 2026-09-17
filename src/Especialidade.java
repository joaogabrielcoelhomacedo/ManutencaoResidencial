public class Especialidade {

    private int idEspecialidade;
    private Profissional profissional;
    private int idCategoria;
    private String experiencia;

    public Especialidade() {
    }

    public Especialidade(int idEspecialidade, Profissional profissional,
                         int idCategoria, String experiencia) {

        this.idEspecialidade = idEspecialidade;
        this.profissional = profissional;
        this.idCategoria = idCategoria;
        this.experiencia = experiencia;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private int idCategoria;
    private String nome;

    private final List<Especialidade> especialidades = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    public void adicionarEspecialidade(Especialidade especialidade) {
        especialidades.add(especialidade);
    }

    public List<Profissional> listarProfissionais() {
        List<Profissional> resultado = new ArrayList<>();

        for (Especialidade especialidade : especialidades) {
            Profissional profissional = especialidade.getProfissional();

            if (profissional != null && !resultado.contains(profissional)) {
                resultado.add(profissional);
            }
        }

        return resultado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }
}

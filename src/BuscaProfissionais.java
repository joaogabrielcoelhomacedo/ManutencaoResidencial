import java.util.ArrayList;
import java.util.List;

public class BuscaProfissionais {

    private String termoBusca;

    private final List<Profissional> base = new ArrayList<>();

    public void cadastrarNaBase(Profissional profissional) {
        base.add(profissional);
    }

    public List<Profissional> buscar(FiltroBusca criterios) {
        List<Profissional> encontrados = criterios.aplicar(base);

        if (termoBusca == null || termoBusca.isEmpty()) {
            return encontrados;
        }

        List<Profissional> resultado = new ArrayList<>();

        for (Profissional profissional : encontrados) {
            if (profissional.getNome().toLowerCase().contains(termoBusca.toLowerCase())) {
                resultado.add(profissional);
            }
        }

        return resultado;
    }

    public String getTermoBusca() {
        return termoBusca;
    }

    public void setTermoBusca(String termoBusca) {
        this.termoBusca = termoBusca;
    }
}

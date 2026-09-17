import java.util.ArrayList;
import java.util.List;

public class FiltroCategoria implements FiltroBusca {

    private final Categoria categoria;

    public FiltroCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public List<Profissional> aplicar(List<Profissional> profissionais) {
        List<Profissional> resultado = new ArrayList<>();

        for (Profissional profissional : profissionais) {
            for (Especialidade especialidade : profissional.getEspecialidades()) {
                if (especialidade.getIdCategoria() == categoria.getIdCategoria()
                        && !resultado.contains(profissional)) {
                    resultado.add(profissional);
                }
            }
        }

        return resultado;
    }
}

import java.util.ArrayList;
import java.util.List;

public class FiltroRegiao implements FiltroBusca {

    private final String regiao;

    public FiltroRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public List<Profissional> aplicar(List<Profissional> profissionais) {
        List<Profissional> resultado = new ArrayList<>();

        for (Profissional profissional : profissionais) {
            if (regiao.equalsIgnoreCase(profissional.getRegiaoAtendimento())) {
                resultado.add(profissional);
            }
        }

        return resultado;
    }
}

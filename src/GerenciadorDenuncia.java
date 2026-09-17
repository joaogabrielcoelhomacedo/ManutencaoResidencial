import java.util.ArrayList;
import java.util.List;

public class GerenciadorDenuncia {

    private final List<Denuncia> denuncias = new ArrayList<>();

    public void registrar(Denuncia denuncia) {
        denuncias.add(denuncia);
    }

    public List<Denuncia> analisarPendentes() {
        List<Denuncia> pendentes = new ArrayList<>();

        for (Denuncia denuncia : denuncias) {
            if (denuncia.consultarStatus().equals("PENDENTE")) {
                denuncia.analisar();
                pendentes.add(denuncia);
            }
        }

        return pendentes;
    }

    public void arquivar(int idDenuncia) {
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getIdDenuncia() == idDenuncia) {
                denuncia.arquivar();
            }
        }
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }
}

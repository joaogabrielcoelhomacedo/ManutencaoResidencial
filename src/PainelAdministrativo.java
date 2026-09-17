public class PainelAdministrativo implements GerenciamentoUsuarios, GerenciamentoCatalogo,
        GerenciamentoModeracao, Estatisticas {

    private int idAdmin;
    private int idUsuario;

    public PainelAdministrativo() {
    }

    public PainelAdministrativo(int idAdmin, int idUsuario) {
        this.idAdmin = idAdmin;
        this.idUsuario = idUsuario;
    }

    @Override
    public void gerenciarClientes() {
        System.out.println("Gerenciando clientes cadastrados");
    }

    @Override
    public void gerenciarProfissionais() {
        System.out.println("Gerenciando profissionais cadastrados");
    }

    @Override
    public void gerenciarCategorias() {
        System.out.println("Gerenciando categorias de servico");
    }

    @Override
    public void gerenciarServicos() {
        System.out.println("Gerenciando servicos em andamento");
    }

    @Override
    public void bloquearUsuario(int idUsuario) {
        System.out.println("Usuario " + idUsuario + " bloqueado");
    }

    @Override
    public void gerenciarAvaliacoes() {
        System.out.println("Gerenciando avaliacoes publicadas");
    }

    @Override
    public void verEstatisticas() {
        System.out.println("Exibindo estatisticas da plataforma");
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

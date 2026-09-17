public class Cliente extends Usuario {

    public Cliente() {
    }

    public Cliente(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "CLIENTE";
    }

    public SolicitacaoServico solicitarServico(Categoria categoria) {
        SolicitacaoServico solicitacao = new SolicitacaoServico();
        solicitacao.setIdCliente(this.idUsuario);
        solicitacao.setIdCategoria(categoria.getIdCategoria());
        solicitacao.atualizarStatus("ABERTA");
        return solicitacao;
    }

    public Avaliacao avaliarProfissional(ExecucaoServico execucao, int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdExecucao(execucao.getIdExecucao());
        avaliacao.setIdCliente(this.idUsuario);
        avaliacao.setNota(nota);
        avaliacao.setComentario(comentario);
        return avaliacao;
    }
}

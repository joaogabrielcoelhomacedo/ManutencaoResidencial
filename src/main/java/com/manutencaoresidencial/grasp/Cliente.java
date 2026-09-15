package com.manutencaoresidencial.grasp;

// GRASP: Creator - Cliente cria SolicitacaoServico e Avaliacao, com quem tem os dados de contexto
public class Cliente extends Usuario {

    public Cliente(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "CLIENTE";
    }

    public SolicitacaoServico solicitarServico(Categoria categoria) {
        // Cliente é quem tem os dados necessários (id, categoria) para criar a solicitação
        return new SolicitacaoServico(0, this.idUsuario, categoria.getIdCategoria(), 0, "", "PENDENTE");
    }

    public Avaliacao avaliarProfissional(ExecucaoServico execucao, int nota, String comentario) {
        // Cliente cria a Avaliacao a partir de uma execução concluída
        return new Avaliacao(0, execucao.getIdExecucao(), this.idUsuario, 0, nota, comentario);
    }
}

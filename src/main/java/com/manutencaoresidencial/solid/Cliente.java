package com.manutencaoresidencial.solid;

// SOLID: LSP - Cliente cumpre o contrato de Usuario sem exigir nada a mais de quem o utiliza como Usuario
public class Cliente extends Usuario {

    public Cliente(int idUsuario, String nome, String email, String senha, String telefone) {
        super(idUsuario, nome, email, senha, telefone);
    }

    @Override
    public String perfil() {
        return "CLIENTE";
    }

    public SolicitacaoServico solicitarServico(Categoria categoria, SolicitacaoServicoService service) {
        // SOLID: DIP - depende do service (abstração de caso de uso), não de uma implementação de persistência
        return service.criar(this.idUsuario, categoria.getIdCategoria());
    }
}

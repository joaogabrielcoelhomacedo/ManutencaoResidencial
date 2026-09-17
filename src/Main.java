import java.util.List;

public class Main {

    public static void main(String[] args) {
        Categoria eletrica = new Categoria(1, "Eletrica");

        Cliente cliente = new Cliente(1, "Joao Macedo", "joao@email.com", "senha123", "85999990000");
        Profissional profissional = new Profissional(2, "Carlos Eletricista", "carlos@email.com",
                "senha456", "85988880000", "Fortaleza");
        Administrador administrador = new Administrador(3, "Ana Admin", "ana@email.com",
                "senha789", "85977770000");

        System.out.println("=== CADASTRO ===");
        System.out.println(cliente.getNome() + " cadastrado: " + cliente.cadastrar()
                + " | perfil: " + cliente.perfil());
        System.out.println(profissional.getNome() + " cadastrado: " + profissional.cadastrar()
                + " | perfil: " + profissional.perfil());
        System.out.println(administrador.getNome() + " | perfil: " + administrador.perfil());

        Endereco endereco = new Endereco(1, cliente.getIdUsuario(), "Rua das Flores, 120",
                "Fortaleza", "CE", "60000-000");
        endereco.cadastrarEndereco();

        profissional.adicionarEspecialidade(eletrica, "8 anos");
        profissional.definirDisponibilidade(new Disponibilidade(1, "SEGUNDA", "08:00", "17:00"));

        System.out.println();
        System.out.println("=== BUSCA DE PROFISSIONAIS ===");
        BuscaProfissionais busca = new BuscaProfissionais();
        busca.cadastrarNaBase(profissional);
        FiltroBusca filtroCategoria = new FiltroCategoria(eletrica);
        List<Profissional> porCategoria = busca.buscar(filtroCategoria);
        System.out.println("Profissionais na categoria " + eletrica.getNome() + ": " + porCategoria.size());
        for (Profissional encontrado : porCategoria) {
            System.out.println("- " + encontrado.getNome() + " (" + encontrado.getRegiaoAtendimento() + ")");
        }

        FiltroBusca filtroRegiao = new FiltroRegiao("Fortaleza");
        List<Profissional> porRegiao = busca.buscar(filtroRegiao);
        System.out.println("Profissionais em Fortaleza: " + porRegiao.size());

        System.out.println();
        System.out.println("=== SOLICITACAO E ORCAMENTO ===");
        Repositorio<SolicitacaoServico> repositorio = new RepositorioSolicitacao();
        Historico historico = new Historico(repositorio);

        SolicitacaoServico solicitacao = cliente.solicitarServico(eletrica);
        solicitacao.setIdSolicitacao(1);
        solicitacao.setIdEndereco(endereco.getIdEndereco());
        solicitacao.setDescricao("Tomada da cozinha sem energia");
        solicitacao.setUrgencia("ALTA");
        repositorio.salvar(solicitacao);
        System.out.println("Solicitacao aberta: " + solicitacao.getDescricao()
                + " | status: " + solicitacao.consultarStatus());

        Orcamento orcamento = profissional.enviarOrcamento(solicitacao, 350.0);
        orcamento.setIdOrcamento(1);
        orcamento.setMateriaisInclusos("Fiacao e disjuntor");
        orcamento.setPrazoEstimado("2 dias");
        historico.registrar(orcamento);
        System.out.println("Orcamento de R$ " + orcamento.getValor()
                + " | status: " + orcamento.consultarStatus());

        orcamento.aceitar();
        System.out.println("Apos aceite | status do orcamento: " + orcamento.consultarStatus());

        System.out.println();
        System.out.println("=== AGENDAMENTO E EXECUCAO ===");
        Agendamento agendamento = new Agendamento(1, orcamento.getIdOrcamento(), "SEGUNDA 09:00");
        agendamento.confirmar();
        agendamento.enviarLembrete();
        historico.registrar(agendamento);
        System.out.println("Conflito na agenda do profissional: "
                + profissional.getDisponibilidades().get(0).verificarConflito(agendamento.getDataHora()));

        ExecucaoServico execucao = agendamento.iniciarExecucao();
        execucao.setIdExecucao(1);
        execucao.setDataInicio("2026-09-21");
        execucao.finalizarServico();
        execucao.setDataFim("2026-09-21");
        execucao.confirmarConclusao();
        solicitacao.atualizarStatus("CONCLUIDA");
        historico.registrar(execucao);
        System.out.println("Execucao " + execucao.getStatus()
                + " | solicitacao: " + solicitacao.consultarStatus());

        System.out.println();
        System.out.println("=== PAGAMENTO ===");
        GatewayPagamento gateway = new GatewayPagamentoExterno("PagamentoSeguro");
        Pagamento pagamento = execucao.gerarPagamento(orcamento.getValor(), "PIX");
        pagamento.setIdPagamento(1);
        pagamento.setGateway(gateway);
        pagamento.setDataPagamento("2026-09-21");
        boolean aprovado = pagamento.registrarPagamento();
        historico.registrar(pagamento);
        System.out.println("Pagamento aprovado: " + aprovado
                + " | status: " + pagamento.consultarStatus());

        System.out.println();
        System.out.println("=== AVALIACAO E DENUNCIA ===");
        Avaliacao avaliacao = cliente.avaliarProfissional(execucao, 5, "Servico rapido e bem feito");
        avaliacao.setIdAvaliacao(1);
        avaliacao.setIdProfissional(profissional.getIdUsuario());
        historico.registrar(avaliacao);

        profissional.receberAvaliacao(avaliacao.getNota(), avaliacao.getComentario());
        profissional.receberAvaliacao(4, "Atendeu no prazo");
        System.out.println("Media do profissional: " + profissional.getMediaAvaliacao());

        GerenciadorDenuncia gerenciadorDenuncia = new GerenciadorDenuncia();
        Denuncia denuncia = avaliacao.denunciar("Comentario indevido");
        denuncia.setIdDenuncia(1);
        denuncia.setData("2026-09-22");
        gerenciadorDenuncia.registrar(denuncia);
        System.out.println("Denuncias em analise: " + gerenciadorDenuncia.analisarPendentes().size()
                + " | status: " + denuncia.consultarStatus());

        System.out.println();
        System.out.println("=== NOTIFICACAO ===");
        CanalNotificacao canalEmail = new NotificadorEmail();
        Notificacao notificacaoEmail = new Notificacao(1, cliente.getIdUsuario(), "SERVICO",
                "Seu servico foi concluido com sucesso", "2026-09-21", canalEmail);
        notificacaoEmail.enviar(cliente);
        notificacaoEmail.marcarComoLida();
        System.out.println("Notificacao lida: " + notificacaoEmail.isLida());

        CanalNotificacao canalSms = new NotificadorSms();
        Notificacao notificacaoSms = new Notificacao(2, cliente.getIdUsuario(), "LEMBRETE",
                "Nao esqueca de avaliar o profissional", "2026-09-21", canalSms);
        notificacaoSms.enviar(cliente);

        System.out.println();
        System.out.println("=== HISTORICO DO CLIENTE ===");
        System.out.println("Solicitacoes: " + historico.listarSolicitacoes(cliente.getIdUsuario()).size());
        System.out.println("Avaliacoes: " + historico.listarAvaliacoes(cliente.getIdUsuario()).size());
        System.out.println("Orcamentos do profissional: "
                + historico.listarOrcamentos(profissional.getIdUsuario()).size());

        System.out.println();
        System.out.println("=== PAINEL ADMINISTRATIVO ===");
        PainelAdministrativo painel = new PainelAdministrativo(1, administrador.getIdUsuario());
        painel.gerenciarProfissionais();
        painel.verEstatisticas();
    }
}

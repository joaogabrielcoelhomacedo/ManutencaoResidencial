# Manutenção Residencial — Diagramas e Código (GRASP e SOLID)

Sistema de intermediação de serviços de manutenção residencial (conecta **Clientes** que precisam de
um serviço a **Profissionais** que o executam), modelado em três etapas: diagrama original, aplicação
dos princípios **GRASP** e aplicação dos princípios **SOLID**.

## 1. Diagrama de classes — antes (original)

Versão inicial do domínio, sem anotação de padrões de design.

```mermaid
classDiagram
    class Usuario {
        <<abstract>>
        -idUsuario: int
        -nome: String
        -email: String
        -senha: String
        -telefone: String
        -fotoPerfil: String
        +cadastrar() boolean
        +login(email, senha) boolean
        +logout() void
        +recuperarSenha(email) void
        +editarDados() void
        +perfil() String
    }
    class Cliente {
        +perfil() String
        +solicitarServico(categoria) SolicitacaoServico
        +avaliarProfissional(execucao, nota, comentario) Avaliacao
    }
    class Profissional {
        -descricao: String
        -regiaoAtendimento: String
        -mediaAvaliacao: double
        +perfil() String
        +getMediaAvaliacao() double
        +receberAvaliacao(nota, comentario) void
        +adicionarEspecialidade(categoria, exp) void
        +definirDisponibilidade(disp) void
        +enviarOrcamento(solicitacao, valor) Orcamento
    }
    class Administrador {
        +perfil() String
    }
    class Endereco {
        -idEndereco: int
        -idUsuario: int
        -logradouro: String
        -cidade: String
        -estado: String
        -cep: String
        +cadastrarEndereco() void
        +editarEndereco() void
    }
    class Notificacao {
        -tipo: String
        -mensagem: String
        -lida: boolean
        +enviar() void
        +marcarComoLida() void
    }
    class CanalNotificacao {
        <<interface>>
        +enviar(mensagem, destinatario) void
    }
    class NotificadorEmail {
        +enviar(mensagem, destinatario) void
    }
    class SolicitacaoServico {
        -descricao: String
        -urgencia: String
        -status: String
        +cancelar() void
        +consultarStatus() String
        +atualizarStatus(status) void
    }
    class Orcamento {
        -valor: double
        -status: String
        +aceitar() void
        +recusar() void
        +solicitarAlteracao() void
        +consultarStatus() String
    }
    class Especialidade {
        -experiencia: String
        +getExperiencia() String
    }
    class Disponibilidade {
        -diaSemana: String
        -horaInicio: String
        -horaFim: String
        +verificarConflito(dataHora) boolean
    }
    class Avaliavel {
        <<interface>>
        +receberAvaliacao(nota, comentario) void
        +getMediaAvaliacao() double
    }
    class PainelAdministrativo {
        +gerenciarClientes() void
        +gerenciarProfissionais() void
        +gerenciarCategorias() void
        +gerenciarServicos() void
        +bloquearUsuario(id) void
        +analisarDenuncias() void
        +gerenciarAvaliacoes() void
        +verEstatisticas() void
    }
    class Categoria {
        -nome: String
        +listarProfissionais() List
    }
    class BuscaProfissionais {
        -termoBusca: String
        +buscar(criterios) List
    }
    class FiltroBusca {
        <<interface>>
        +aplicar(profissionais) List
    }
    class FiltroCategoria {
        +aplicar(profissionais) List
    }
    class Agendamento {
        -dataHora: String
        -status: String
        +confirmar() void
        +reagendar(novaData) void
        +cancelar() void
        +enviarLembrete() void
    }
    class ExecucaoServico {
        -status: String
        +iniciarServico() void
        +atualizarStatus(status) void
        +finalizarServico() void
        +confirmarConclusao() void
    }
    class Pagamento {
        -valorFinal: double
        -statusPagamento: String
        +registrarPagamento() boolean
        +consultarStatus() String
    }
    class Avaliacao {
        -nota: int
        -comentario: String
        +calcularMedia() double
        +denunciar() void
    }
    class GatewayPagamento {
        <<interface>>
        +processarPagamento(valor, forma) boolean
    }
    class GatewayPagamentoExterno {
        -provedor: String
        +processarPagamento(valor, forma) boolean
    }
    class Historico {
        +listarSolicitacoes(idUsuario) List
        +listarOrcamentos(idUsuario) List
        +listarAgendamentos(idUsuario) List
        +listarExecucoes(idUsuario) List
        +listarPagamentos(idUsuario) List
        +listarAvaliacoes(idUsuario) List
    }
    class Repositorio~T~ {
        <<interface>>
        +salvar(entidade) void
        +listarPorUsuario(idUsuario) List
    }
    class RepositorioSolicitacao {
        +salvar(entidade) void
        +listarPorUsuario(idUsuario) List
    }

    Usuario <|-- Cliente
    Usuario <|-- Profissional
    Usuario <|-- Administrador
    Profissional ..|> Avaliavel
    NotificadorEmail ..|> CanalNotificacao
    FiltroCategoria ..|> FiltroBusca
    GatewayPagamentoExterno ..|> GatewayPagamento
    RepositorioSolicitacao ..|> Repositorio
    Usuario "1" --> "*" Endereco
    Usuario "1" --> "*" Notificacao
    Cliente "1" --> "*" SolicitacaoServico
    SolicitacaoServico "1" --> "*" Orcamento
    Profissional "1" --> "*" Especialidade
    Profissional "1" --> "*" Disponibilidade
    Categoria "1" --> "*" Profissional
    Orcamento "1" --> "0..1" Agendamento
    Agendamento "1" --> "1" ExecucaoServico
    ExecucaoServico "1" --> "0..1" Avaliacao
    ExecucaoServico "1" --> "1" Pagamento
    PainelAdministrativo "1" --> "1" Usuario : administra
    BuscaProfissionais ..> FiltroBusca : depende de
    FiltroBusca ..> Categoria : consulta
    Historico ..> Repositorio : consulta
    Pagamento ..> GatewayPagamento : depende de
    Notificacao ..> CanalNotificacao : depende de
```

## 2. Diagrama de classes — princípios GRASP aplicados

Cada classe traz o padrão GRASP identificado (Information Expert, Creator, Controller, Low Coupling,
High Cohesion, Polymorphism, Pure Fabrication, Indirection, Protected Variations).

```mermaid
classDiagram
    class Usuario {
        <<abstract>>
        GRASP: Polymorphism base
        +cadastrar() boolean
        +login(email, senha) boolean
        +perfil() String
    }
    class Cliente {
        GRASP: Creator
        +solicitarServico(categoria) SolicitacaoServico
        +avaliarProfissional(execucao, nota, comentario) Avaliacao
    }
    class Profissional {
        GRASP: Creator + Info Expert
        +enviarOrcamento(solicitacao, valor) Orcamento
        +receberAvaliacao(nota, comentario) void
    }
    class Administrador {
        GRASP: Polymorphism
        +perfil() String
    }
    class Endereco {
        GRASP: Info Expert
    }
    class Notificacao {
        GRASP: Low Coupling
        +enviar() void
    }
    class CanalNotificacao {
        <<interface>>
        GRASP: Protected Variations
    }
    class NotificadorEmail {
        GRASP: Polymorphism
    }
    class SolicitacaoServico {
        GRASP: Info Expert
        +atualizarStatus(status) void
    }
    class Orcamento {
        GRASP: Info Expert
    }
    class Especialidade {
        GRASP: Info Expert
    }
    class Disponibilidade {
        GRASP: Info Expert
        +verificarConflito(dataHora) boolean
    }
    class Avaliavel {
        <<interface>>
        GRASP: Protected Variations
    }
    class PainelAdministrativo {
        GRASP: Controller
    }
    class Categoria {
        GRASP: Info Expert
        +listarProfissionais() List
    }
    class BuscaProfissionais {
        GRASP: Controller + Pure Fabrication
        +buscar(criterios) List
    }
    class FiltroBusca {
        <<interface>>
        GRASP: Protected Variations
    }
    class FiltroCategoria {
        GRASP: Polymorphism
    }
    class Agendamento {
        GRASP: Creator + Controller
    }
    class ExecucaoServico {
        GRASP: Creator + Controller
    }
    class Pagamento {
        GRASP: Low Coupling
    }
    class Avaliacao {
        GRASP: Info Expert
        +calcularMedia() double
    }
    class GatewayPagamento {
        <<interface>>
        GRASP: Protected Variations
    }
    class GatewayPagamentoExterno {
        GRASP: Polymorphism
    }
    class Historico {
        GRASP: Pure Fabrication
    }
    class Repositorio~T~ {
        <<interface>>
        GRASP: Protected Variations
    }
    class RepositorioSolicitacao {
        GRASP: Polymorphism
    }

    Usuario <|-- Cliente
    Usuario <|-- Profissional
    Usuario <|-- Administrador
    Profissional ..|> Avaliavel
    NotificadorEmail ..|> CanalNotificacao
    FiltroCategoria ..|> FiltroBusca
    GatewayPagamentoExterno ..|> GatewayPagamento
    RepositorioSolicitacao ..|> Repositorio
    Cliente "1" --> "*" SolicitacaoServico
    SolicitacaoServico "1" --> "*" Orcamento
    Orcamento "1" --> "0..1" Agendamento
    Agendamento "1" --> "1" ExecucaoServico
    ExecucaoServico "1" --> "0..1" Avaliacao
    ExecucaoServico "1" --> "1" Pagamento
    PainelAdministrativo "1" --> "1" Usuario : administra
    BuscaProfissionais ..> FiltroBusca : depende de
    Historico ..> Repositorio : consulta
    Pagamento ..> GatewayPagamento : depende de
```

## 3. Diagrama de classes — princípios SOLID aplicados

A mesma modelagem, reestruturada para deixar explícitos os 5 princípios SOLID. Principais mudanças
em relação à versão GRASP:

- **SRP** — entidades (`SolicitacaoServico`, `Orcamento`, `Avaliacao`, `Notificacao`) passam a guardar
  só dados; a regra de negócio migra para *services* dedicados (`SolicitacaoServicoService`,
  `OrcamentoService`, `AvaliacaoService`, `NotificacaoService`).
- **OCP** — `FiltroBusca`, `CanalNotificacao` e `GatewayPagamento` ganham uma segunda implementação
  cada (`FiltroRegiao`, `NotificadorSms`) mostrando que dá pra estender sem alterar código existente.
- **LSP** — `Cliente`, `Profissional` e `Administrador` continuam substituindo `Usuario` sem quebrar
  o contrato de `perfil()`.
- **ISP** — o `PainelAdministrativo`, que no diagrama original tinha 8 métodos numa interface só, é
  dividido em `GerenciamentoUsuarios`, `GerenciamentoCatalogo`, `GerenciamentoModeracao` e
  `Estatisticas`.
- **DIP** — `Pagamento` e `Historico` recebem a abstração (`GatewayPagamento`, `Repositorio`) via
  construtor, em vez de instanciar a implementação concreta.

```mermaid
classDiagram
    class Usuario {
        <<abstract>>
        SOLID: LSP
        +login(email, senha) boolean
        +perfil() String
    }
    class Cliente {
        SOLID: LSP
        +solicitarServico(categoria, service) SolicitacaoServico
    }
    class Profissional {
        SOLID: SRP
    }
    class Administrador {
        SOLID: LSP
    }
    class SolicitacaoServico {
        SOLID: SRP
        (só dados e status)
    }
    class SolicitacaoServicoService {
        SOLID: SRP + DIP
        +criar(idCliente, idCategoria) SolicitacaoServico
    }
    class Orcamento {
        SOLID: SRP
    }
    class OrcamentoService {
        SOLID: SRP
        +enviarOrcamento(solicitacao, profissional, valor) Orcamento
    }
    class Avaliacao {
        SOLID: SRP
    }
    class AvaliacaoService {
        SOLID: SRP
        +calcularMedia(idProfissional) double
    }
    class Notificacao {
        SOLID: SRP
    }
    class NotificacaoService {
        SOLID: SRP + DIP
        +enviar(notificacao, destinatario) void
    }
    class CanalNotificacao {
        <<interface>>
        SOLID: OCP + DIP
    }
    class NotificadorEmail {
        SOLID: OCP
    }
    class NotificadorSms {
        SOLID: OCP extensao
    }
    class FiltroBusca {
        <<interface>>
        SOLID: OCP
    }
    class FiltroCategoria {
        SOLID: OCP
    }
    class FiltroRegiao {
        SOLID: OCP extensao
    }
    class BuscaProfissionaisService {
        SOLID: DIP
        +buscar(base, criterio) List
    }
    class GerenciamentoUsuarios {
        <<interface>>
        SOLID: ISP
    }
    class GerenciamentoCatalogo {
        <<interface>>
        SOLID: ISP
    }
    class GerenciamentoModeracao {
        <<interface>>
        SOLID: ISP
    }
    class Estatisticas {
        <<interface>>
        SOLID: ISP
    }
    class PainelAdministrativo {
        SOLID: ISP
    }
    class GatewayPagamento {
        <<interface>>
        SOLID: OCP + DIP
    }
    class GatewayPagamentoExterno {
        SOLID: OCP
    }
    class Pagamento {
        SOLID: DIP
        +registrarPagamento(forma) boolean
    }
    class Repositorio~T~ {
        <<interface>>
        SOLID: DIP
    }
    class RepositorioSolicitacao {
        SOLID: OCP
    }
    class Historico {
        SOLID: SRP + DIP
    }

    Usuario <|-- Cliente
    Usuario <|-- Profissional
    Usuario <|-- Administrador
    NotificadorEmail ..|> CanalNotificacao
    NotificadorSms ..|> CanalNotificacao
    FiltroCategoria ..|> FiltroBusca
    FiltroRegiao ..|> FiltroBusca
    GatewayPagamentoExterno ..|> GatewayPagamento
    RepositorioSolicitacao ..|> Repositorio
    PainelAdministrativo ..|> GerenciamentoUsuarios
    PainelAdministrativo ..|> GerenciamentoCatalogo
    PainelAdministrativo ..|> GerenciamentoModeracao
    PainelAdministrativo ..|> Estatisticas
    Cliente ..> SolicitacaoServicoService : usa
    SolicitacaoServicoService ..> Repositorio : depende de
    NotificacaoService ..> CanalNotificacao : depende de
    BuscaProfissionaisService ..> FiltroBusca : depende de
    Pagamento ..> GatewayPagamento : depende de
    Historico ..> Repositorio : depende de
```

## Estrutura do repositório

```
ManutencaoResidencial/
├── README.md                 <- este arquivo (diagramas + explicação)
└── src/main/java/com/manutencaoresidencial/
    ├── grasp/                <- código Java da versão com princípios GRASP
    └── solid/                <- código Java da versão com princípios SOLID
```

## Sobre o projeto

Trabalho acadêmico de modelagem de sistema — domínio de intermediação de serviços de manutenção
residencial (conecta clientes que precisam de um reparo/serviço a profissionais disponíveis na
região, com fluxo de solicitação → orçamento → agendamento → execução → pagamento → avaliação).

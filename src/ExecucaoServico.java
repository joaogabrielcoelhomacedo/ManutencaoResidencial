import java.util.ArrayList;
import java.util.List;

public class ExecucaoServico {

    private int idExecucao;
    private int idAgendamento;
    private String dataInicio;
    private String dataFim;
    private String observacoes;
    private final List<String> fotosServico = new ArrayList<>();
    private String status;

    public ExecucaoServico() {
        this.status = "AGUARDANDO";
    }

    public ExecucaoServico(int idExecucao, int idAgendamento, String dataInicio) {
        this.idExecucao = idExecucao;
        this.idAgendamento = idAgendamento;
        this.dataInicio = dataInicio;
        this.status = "AGUARDANDO";
    }

    public void iniciarServico() {
        this.status = "EM_EXECUCAO";
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public void finalizarServico() {
        this.status = "FINALIZADO";
    }

    public void confirmarConclusao() {
        this.status = "CONCLUIDO";
    }

    public Pagamento gerarPagamento(double valorFinal, String formaPagamento) {
        Pagamento pagamento = new Pagamento();
        pagamento.setIdExecucao(this.idExecucao);
        pagamento.setValorFinal(valorFinal);
        pagamento.setFormaPagamento(formaPagamento);
        return pagamento;
    }

    public int getIdExecucao() {
        return idExecucao;
    }

    public void setIdExecucao(int idExecucao) {
        this.idExecucao = idExecucao;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<String> getFotosServico() {
        return fotosServico;
    }

    public String getStatus() {
        return status;
    }
}

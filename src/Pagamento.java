public class Pagamento {

    private int idPagamento;
    private int idExecucao;
    private double valorFinal;
    private String formaPagamento;
    private String statusPagamento;
    private String dataPagamento;

    private GatewayPagamento gateway;

    public Pagamento() {
        this.statusPagamento = "PENDENTE";
    }

    public Pagamento(int idPagamento, int idExecucao, double valorFinal,
                     String formaPagamento, GatewayPagamento gateway) {

        this.idPagamento = idPagamento;
        this.idExecucao = idExecucao;
        this.valorFinal = valorFinal;
        this.formaPagamento = formaPagamento;
        this.gateway = gateway;
        this.statusPagamento = "PENDENTE";
    }

    public boolean registrarPagamento() {
        boolean aprovado = gateway.processarPagamento(valorFinal, formaPagamento);
        this.statusPagamento = aprovado ? "APROVADO" : "RECUSADO";
        return aprovado;
    }

    public String consultarStatus() {
        return statusPagamento;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdExecucao() {
        return idExecucao;
    }

    public void setIdExecucao(int idExecucao) {
        this.idExecucao = idExecucao;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setGateway(GatewayPagamento gateway) {
        this.gateway = gateway;
    }
}

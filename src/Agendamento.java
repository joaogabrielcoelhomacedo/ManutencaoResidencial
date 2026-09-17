public class Agendamento {

    private int idAgendamento;
    private int idOrcamento;
    private String dataHora;
    private String status;

    public Agendamento() {
        this.status = "PENDENTE";
    }

    public Agendamento(int idAgendamento, int idOrcamento, String dataHora) {
        this.idAgendamento = idAgendamento;
        this.idOrcamento = idOrcamento;
        this.dataHora = dataHora;
        this.status = "PENDENTE";
    }

    public void confirmar() {
        this.status = "CONFIRMADO";
    }

    public void reagendar(String novaData) {
        this.dataHora = novaData;
        this.status = "REAGENDADO";
    }

    public void cancelar() {
        this.status = "CANCELADO";
    }

    public void enviarLembrete() {
        System.out.println("Lembrete: servico agendado para " + dataHora);
    }

    public ExecucaoServico iniciarExecucao() {
        ExecucaoServico execucao = new ExecucaoServico();
        execucao.setIdAgendamento(this.idAgendamento);
        execucao.iniciarServico();
        return execucao;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }
}

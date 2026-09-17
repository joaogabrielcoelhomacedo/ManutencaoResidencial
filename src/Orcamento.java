public class Orcamento {

    private int idOrcamento;
    private int idSolicitacao;
    private int idProfissional;
    private double valor;
    private String materiaisInclusos;
    private String prazoEstimado;
    private String status;

    public Orcamento() {
        this.status = "ENVIADO";
    }

    public Orcamento(int idOrcamento, int idSolicitacao, int idProfissional,
                     double valor, String materiaisInclusos, String prazoEstimado) {

        this.idOrcamento = idOrcamento;
        this.idSolicitacao = idSolicitacao;
        this.idProfissional = idProfissional;
        this.valor = valor;
        this.materiaisInclusos = materiaisInclusos;
        this.prazoEstimado = prazoEstimado;
        this.status = "ENVIADO";
    }

    public void aceitar() {
        this.status = "ACEITO";
    }

    public void recusar() {
        this.status = "RECUSADO";
    }

    public void solicitarAlteracao() {
        this.status = "EM_REVISAO";
    }

    public String consultarStatus() {
        return status;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMateriaisInclusos() {
        return materiaisInclusos;
    }

    public void setMateriaisInclusos(String materiaisInclusos) {
        this.materiaisInclusos = materiaisInclusos;
    }

    public String getPrazoEstimado() {
        return prazoEstimado;
    }

    public void setPrazoEstimado(String prazoEstimado) {
        this.prazoEstimado = prazoEstimado;
    }
}

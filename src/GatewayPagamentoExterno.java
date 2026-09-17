public class GatewayPagamentoExterno implements GatewayPagamento {

    private String provedor;

    public GatewayPagamentoExterno(String provedor) {
        this.provedor = provedor;
    }

    @Override
    public boolean processarPagamento(double valor, String forma) {
        System.out.println("[" + provedor + "] processando " + forma + " de R$ " + valor);
        return valor > 0;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }
}

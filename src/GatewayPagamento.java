public interface GatewayPagamento {

    boolean processarPagamento(double valor, String forma);
}

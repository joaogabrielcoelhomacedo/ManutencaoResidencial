public class Endereco {

    private int idEndereco;
    private int idUsuario;
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {
    }

    public Endereco(int idEndereco, int idUsuario, String logradouro,
                    String cidade, String estado, String cep) {

        this.idEndereco = idEndereco;
        this.idUsuario = idUsuario;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public void cadastrarEndereco() {
        if (logradouro != null && cidade != null && cep != null) {
            this.estado = estado == null ? "CE" : estado;
        }
    }

    public void editarEndereco() {
        this.cep = cep == null ? "" : cep.replace("-", "");
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

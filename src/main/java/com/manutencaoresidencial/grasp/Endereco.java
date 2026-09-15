package com.manutencaoresidencial.grasp;

// GRASP: Information Expert - concentra os dados e regras de um endereço
public class Endereco {
    private int idEndereco;
    private int idUsuario;
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(int idEndereco, int idUsuario, String logradouro, String cidade, String estado, String cep) {
        this.idEndereco = idEndereco;
        this.idUsuario = idUsuario;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public void cadastrarEndereco() {
        // valida e persiste o endereço
    }

    public void editarEndereco() {
        // atualiza os dados do endereço
    }

    public int getIdEndereco() { return idEndereco; }
    public int getIdUsuario() { return idUsuario; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }
}

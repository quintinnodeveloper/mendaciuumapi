package br.com.quintinno.mendaciuumapi.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessamentoRequestTransfer {

    private String nome;

    @JsonProperty("mae")
    private String nomeMae;

    @JsonProperty("pai")
    private String nomePai;

    @JsonProperty("data_nasc")
    private String dataNascimento;

    public ProcessamentoRequestTransfer() {}

    public ProcessamentoRequestTransfer(String nome, String nomeMae, String nomePai, String dataNascimento) {
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
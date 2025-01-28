package br.com.quintinno.mendaciuumapi.enumeration;

public enum TipoPessoaEnumeration {

    PESSOA_FISICA (1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private Integer codigo;

    private String nome;

    private TipoPessoaEnumeration(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

}

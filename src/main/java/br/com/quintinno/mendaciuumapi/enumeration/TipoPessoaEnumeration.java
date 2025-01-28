package br.com.quintinno.mendaciuumapi.enumeration;

public enum TipoPessoaEnumeration {

    PESSOA_FISICA (1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private Integer codigo;

    private String descricao;

    private TipoPessoaEnumeration(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}

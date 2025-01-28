package br.com.quintinno.mendaciuumapi.enumeration;

public enum TipoSexoEnumeration {

    MASCULINO (1, "Masculino"),
    FEMININO (2, "Feminino");

    private Integer codigo;

    private String nome;

    private TipoSexoEnumeration(Integer codigo, String nome) {
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

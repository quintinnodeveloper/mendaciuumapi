package br.com.quintinno.mendaciuumapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    private CidadeEntity cidadeEntity;

    @Column(name = "cep", length = 9, nullable = false)
    private String cep;

    @Column(name = "descricao", length = 9, nullable = false)
    private String descricao;

    @Column(name = "numero", length = 9, nullable = false)
    private String numero;

    @Column(name = "bairro", length = 9, nullable = false)
    private String bairro;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public CidadeEntity getCidadeEntity() {
        return cidadeEntity;
    }

    public void setCidadeEntity(CidadeEntity cidadeEntity) {
        this.cidadeEntity = cidadeEntity;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
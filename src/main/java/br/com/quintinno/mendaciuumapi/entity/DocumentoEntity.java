package br.com.quintinno.mendaciuumapi.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_documento")
public class DocumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "id_categoria_documento", nullable = false)
    private CategoriaDocumentoEntity categoriaDocumentoEntity;

    @Column(name = "numero", length = 50, nullable = false)
    private String nome;

    @Column(name = "data_expedicao")
    private LocalDate dataExpedicao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public CategoriaDocumentoEntity getCategoriaDocumentoEntity() {
        return categoriaDocumentoEntity;
    }

    public void setCategoriaDocumentoEntity(CategoriaDocumentoEntity categoriaDocumentoEntity) {
        this.categoriaDocumentoEntity = categoriaDocumentoEntity;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
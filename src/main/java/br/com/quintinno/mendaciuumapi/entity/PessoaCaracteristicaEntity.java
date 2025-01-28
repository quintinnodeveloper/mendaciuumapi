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
@Table(name = "tb_pessoa_caracteristica")
public class PessoaCaracteristicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntity pessoaEntity;

    @ManyToOne
    @JoinColumn(name = "id_caracterista", nullable = false)
    private CaracteristicaEntity caracteristicaEntity;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public PessoaEntity getPessoaEntity() {
        return pessoaEntity;
    }

    public void setPessoaEntity(PessoaEntity pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
    }

    public CaracteristicaEntity getCaracteristicaEntity() {
        return caracteristicaEntity;
    }

    public void setCaracteristicaEntity(CaracteristicaEntity caracteristicaEntity) {
        this.caracteristicaEntity = caracteristicaEntity;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PessoaCaracteristicaEntity other = (PessoaCaracteristicaEntity) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
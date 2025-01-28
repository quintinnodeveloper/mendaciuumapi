package br.com.quintinno.mendaciuumapi.entity;

import java.time.LocalDate;

import br.com.quintinno.mendaciuumapi.enumeration.TipoPessoaEnumeration;
import br.com.quintinno.mendaciuumapi.enumeration.TipoSexoEnumeration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "tipo_pessoa", length = 50, nullable = false)
    private TipoPessoaEnumeration tipoPessoaEnumeration;

    @Column(name = "tipo_sexo", length = 10)
    private TipoSexoEnumeration tipoSexoEnumeration;

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "nome-social", length = 200)
    private String nomeSocial;

    @Column(name = "nome-mae", length = 200)
    private String nomeMae;

    @Column(name = "nome-pai", length = 200)
    private String nomePai;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento = LocalDate.now();

    @Column(name = "e_ativo", nullable = false)
    private Boolean eAtivo = true;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoPessoaEnumeration getTipoPessoaEnumeration() {
        return tipoPessoaEnumeration;
    }

    public void setTipoPessoaEnumeration(TipoPessoaEnumeration tipoPessoaEnumeration) {
        this.tipoPessoaEnumeration = tipoPessoaEnumeration;
    }

    public TipoSexoEnumeration getTipoSexoEnumeration() {
        return tipoSexoEnumeration;
    }

    public void setTipoSexoEnumeration(TipoSexoEnumeration tipoSexoEnumeration) {
        this.tipoSexoEnumeration = tipoSexoEnumeration;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean geteAtivo() {
        return eAtivo;
    }

    public void seteAtivo(Boolean eAtivo) {
        this.eAtivo = eAtivo;
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
        PessoaEntity other = (PessoaEntity) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
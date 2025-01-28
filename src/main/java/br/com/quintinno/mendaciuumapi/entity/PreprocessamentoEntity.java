package br.com.quintinno.mendaciuumapi.entity;

import java.time.LocalDate;

import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.enumeration.TipoPessoaEnumeration;
import br.com.quintinno.mendaciuumapi.enumeration.TipoSexoEnumeration;
import br.com.quintinno.mendaciuumapi.enumeration.TipoSituacaoProcessamentoEnumeration;
import br.com.quintinno.mendaciuumapi.utility.DateUtility;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_preprocessamento")
public class PreprocessamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "protocolo", nullable = false)
    private String numeroProtocolo;

    @Column(name = "tipo_pessoa", length = 50)
    private TipoPessoaEnumeration tipoPessoaEnumeration;

    @Column(name = "tipo_sexo", length = 10)
    private TipoSexoEnumeration tipoSexoEnumeration;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "nome-social", length = 200)
    private String nomeSocial;

    @Column(name = "nome-mae", length = 200)
    private String nomeMae;

    @Column(name = "nome-pai", length = 200)
    private String nomePai;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "tipo_situacao_processamento", nullable = false)
    private TipoSituacaoProcessamentoEnumeration tipoSituacaoProcessamentoEnumeration;

    public static PreprocessamentoEntity getToEntity(ProcessamentoRequestDTO processamentoRequestDTO) {
        PreprocessamentoEntity preprocessamentoEntity = new PreprocessamentoEntity();
            preprocessamentoEntity.setNumeroProtocolo(processamentoRequestDTO.getNumeroProtocolo());
            preprocessamentoEntity.setTipoPessoaEnumeration(TipoPessoaEnumeration.PESSOA_FISICA);
            preprocessamentoEntity.setTipoSexoEnumeration(TipoSexoEnumeration.MASCULINO);
            preprocessamentoEntity.setNome(processamentoRequestDTO.getNome());
            preprocessamentoEntity.setNomeMae(processamentoRequestDTO.getNomeMae());
            preprocessamentoEntity.setNomePai(processamentoRequestDTO.getNomePai());
            preprocessamentoEntity.setDataNascimento(DateUtility.getData(processamentoRequestDTO.getDataNascimento(), DateUtility.getFormatoDDMMYYYY()));
        return preprocessamentoEntity;
    }

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

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public TipoSituacaoProcessamentoEnumeration getTipoSituacaoProcessamentoEnumeration() {
        return tipoSituacaoProcessamentoEnumeration;
    }

    public void setTipoSituacaoProcessamentoEnumeration(
            TipoSituacaoProcessamentoEnumeration tipoSituacaoProcessamentoEnumeration) {
        this.tipoSituacaoProcessamentoEnumeration = tipoSituacaoProcessamentoEnumeration;
    }

}

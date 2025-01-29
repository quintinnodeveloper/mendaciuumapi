package br.com.quintinno.mendaciuumapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.quintinno.mendaciuumapi.enumeration.TipoSituacaoProcessamentoEnumeration;

public class PreprocessamentoResponseDTO {

    @JsonProperty("situacao")
    private TipoSituacaoProcessamentoEnumeration tipoSituacaoProcessamentoEnumeration;

    @JsonProperty("processados")
    private String quantidadeRegistrosProcessados;

    public TipoSituacaoProcessamentoEnumeration getTipoSituacaoProcessamentoEnumeration() {
        return tipoSituacaoProcessamentoEnumeration;
    }

    public void setTipoSituacaoProcessamentoEnumeration(
            TipoSituacaoProcessamentoEnumeration tipoSituacaoProcessamentoEnumeration) {
        this.tipoSituacaoProcessamentoEnumeration = tipoSituacaoProcessamentoEnumeration;
    }

    public String getQuantidadeRegistrosProcessados() {
        return quantidadeRegistrosProcessados;
    }

    public void setQuantidadeRegistrosProcessados(String quantidadeRegistrosProcessados) {
        this.quantidadeRegistrosProcessados = quantidadeRegistrosProcessados;
    }

}

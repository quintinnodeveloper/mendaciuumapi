package br.com.quintinno.mendaciuumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintinno.mendaciuumapi.dto.PreprocessamentoResponseDTO;
import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.entity.PreprocessamentoEntity;
import br.com.quintinno.mendaciuumapi.enumeration.TipoSituacaoProcessamentoEnumeration;
import br.com.quintinno.mendaciuumapi.repository.PreprocessamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class PreprocessamentoService {

    private PreprocessamentoRepository preprocessamentoRepository;

    public PreprocessamentoService(PreprocessamentoRepository preprocessamentoRepository) {
        this.preprocessamentoRepository = preprocessamentoRepository;
    }

    @Transactional
    void preprocessar(ProcessamentoRequestDTO processamentoRequestDTO) {
        this.preprocessamentoRepository.save(PreprocessamentoEntity.getToEntity(processamentoRequestDTO));
    }

    public PreprocessamentoResponseDTO acompanharProcessamento(String numeroProtocolo) {
        List<PreprocessamentoEntity> preprocessamentoEntityList = this.preprocessamentoRepository.findByNumeroProtocolo(numeroProtocolo);
        long quantidadeRegistrosAceitos = preprocessamentoEntityList.stream().filter(
                preprocessamento -> preprocessamento.getTipoSituacaoProcessamentoEnumeration() == TipoSituacaoProcessamentoEnumeration.ACEITO).count();
        PreprocessamentoResponseDTO preprocessamentoResponseDTO = new PreprocessamentoResponseDTO();
            preprocessamentoResponseDTO.setQuantidadeRegistrosProcessados(String.valueOf(0));
            preprocessamentoResponseDTO.setTipoSituacaoProcessamentoEnumeration(TipoSituacaoProcessamentoEnumeration.ACEITO);
        return preprocessamentoResponseDTO;
    }

}

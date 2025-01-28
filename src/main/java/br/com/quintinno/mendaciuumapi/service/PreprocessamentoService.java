package br.com.quintinno.mendaciuumapi.service;

import org.springframework.stereotype.Service;

import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.entity.PreprocessamentoEntity;
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

}

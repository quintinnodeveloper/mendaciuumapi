package br.com.quintinno.mendaciuumapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.quintinno.mendaciuumapi.dto.PreprocessamentoResponseDTO;
import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.dto.ProcessamentoResponseDTO;
import br.com.quintinno.mendaciuumapi.entity.PessoaEntity;
import br.com.quintinno.mendaciuumapi.entity.PreprocessamentoEntity;
import br.com.quintinno.mendaciuumapi.enumeration.TipoSituacaoProcessamentoEnumeration;
import br.com.quintinno.mendaciuumapi.repository.ProcessamentoImplementacaoRepository;
import br.com.quintinno.mendaciuumapi.utility.DateUtility;
import br.com.quintinno.mendaciuumapi.utility.MensagemUtitliy;

@Service
public class ProcessamentoService {

    private PreprocessamentoService preprocessamentoService;

    private ProcessamentoImplementacaoRepository processamentoImplementacaoRepository;

    private PessoaService pessoaService; 

    public ProcessamentoService(
            PreprocessamentoService preprocessamentoService, 
            ProcessamentoImplementacaoRepository processamentoImplementacaoRepository,
            PessoaService pessoaService) {
        this.preprocessamentoService = preprocessamentoService;
        this.processamentoImplementacaoRepository = processamentoImplementacaoRepository;
        this.pessoaService = pessoaService;
    }

    public ProcessamentoResponseDTO preprocessamento(List<ProcessamentoRequestDTO> processamentoRequestDTOList) {
        UUID numeroProtocolo = UUID.randomUUID();
        processamentoRequestDTOList.stream().forEach( processamentoRequestDTO ->
            processamentoRequestDTO.setNumeroProtocolo(numeroProtocolo.toString())
        );
        processamentoRequestDTOList.stream().forEach( processamentoRequestDTO ->
            this.preprocessamentoService.preprocessar(processamentoRequestDTO)
        );
        ProcessamentoResponseDTO processamentoResponseDTO = new ProcessamentoResponseDTO();
            processamentoResponseDTO.setDataHora(DateUtility.getDataHoraString(LocalDateTime.now(), DateUtility.getFormatoDDMMYYYYHHMMSS()));
            processamentoResponseDTO.setSituacao(HttpStatus.ACCEPTED.name());
            processamentoResponseDTO.setMensagem(MensagemUtitliy.MENSAGEM_SUCESSO_PREPROCESSAMENTO);
            processamentoResponseDTO.setUrl("http://localhost:8080/processamento/".concat(numeroProtocolo.toString()));
        return processamentoResponseDTO;
    }

    public PreprocessamentoResponseDTO acompanharProcessamento(@RequestParam String numeroProtocolo) {
        return this.preprocessamentoService.acompanharProcessamento();
    }

    public void create() {

        Set<PreprocessamentoEntity> preprocessamentoEntityList = 
            this.processamentoImplementacaoRepository.findPreprocessamentoBatch(TipoSituacaoProcessamentoEnumeration.AGUARDANDO.name(), 1000);

        preprocessamentoEntityList.stream().forEach( preprocessamento -> {
            try {
                if (!this.processamentoImplementacaoRepository.isPessoaCadastrada(preprocessamento.getNome())) {
                    this.pessoaService.create(PessoaEntity.getToEntity(preprocessamento));
                    preprocessamento.setTipoSituacaoProcessamentoEnumeration(TipoSituacaoProcessamentoEnumeration.FINALIZADO);
                } else {
                    preprocessamento.setTipoSituacaoProcessamentoEnumeration(TipoSituacaoProcessamentoEnumeration.DUPLICADO);
                }
            } catch (Exception e) {
                preprocessamento.setTipoSituacaoProcessamentoEnumeration(TipoSituacaoProcessamentoEnumeration.ERRO);
            }
            this.preprocessamentoService.update(preprocessamento);
        });

    }

}

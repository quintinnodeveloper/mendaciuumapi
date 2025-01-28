package br.com.quintinno.mendaciuumapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.dto.ProcessamentoResponseDTO;
import br.com.quintinno.mendaciuumapi.utility.DateUtility;
import br.com.quintinno.mendaciuumapi.utility.MensagemUtitliy;

@Service
public class ProcessamentoService {

    private PreprocessamentoService preprocessamentoService;

    public ProcessamentoService(PreprocessamentoService preprocessamentoService) {
        this.preprocessamentoService = preprocessamentoService;
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

}

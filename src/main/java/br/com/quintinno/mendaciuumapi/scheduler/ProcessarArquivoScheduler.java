package br.com.quintinno.mendaciuumapi.scheduler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.service.ProcessamentoService;

@Component
public class ProcessarArquivoScheduler {

    private final Logger logger = LoggerFactory.getLogger(ProcessarArquivoScheduler.class);

    private static final String EXTENSAO_ARQUIVO = ".json";

    @Value("${mendaciuumapi.arquivo.upload}")
    public String diretorioUpload;

    private ProcessamentoService processamentoService;

    public ProcessarArquivoScheduler(ProcessamentoService processamentoService) {
        this.processamentoService = processamentoService;
    }

    @Scheduled(fixedRate = 60000)
    public void processarArquivo() {
        
        File diretorioArquivo = new File(diretorioUpload);

        File[] arquivoProcessamentoList = diretorioArquivo.listFiles( 
            ( diretorio, nomeArquivo) -> nomeArquivo.toLowerCase().endsWith(EXTENSAO_ARQUIVO));

        if (arquivoProcessamentoList != null) {
            logger.info("Iniciando Processamento de Arquivos...");
            ObjectMapper objectMapper = new ObjectMapper();
            for (File arquivo : arquivoProcessamentoList) {
                try {
                    ProcessamentoRequestDTO[] processamentoRequestList = objectMapper
                        .readValue(arquivo, ProcessamentoRequestDTO[].class);
                    List<ProcessamentoRequestDTO> processamentoRequestObjectList = Arrays.asList(processamentoRequestList);
                    this.processamentoService.preprocessamento(processamentoRequestObjectList);
                    Files.delete(Paths.get(arquivo.getAbsolutePath()));
                    logger.info("Processamento finalizado com Sucesso...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    
}

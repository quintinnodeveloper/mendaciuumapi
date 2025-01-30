package br.com.quintinno.mendaciuumapi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.quintinno.mendaciuumapi.dto.PreprocessamentoResponseDTO;
import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.entity.PreprocessamentoEntity;
import br.com.quintinno.mendaciuumapi.repository.PreprocessamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class PreprocessamentoService {

    @Value("${mendaciuumapi.arquivo.upload}")
    public String diretorioUpload;

    private PreprocessamentoRepository preprocessamentoRepository;

    public PreprocessamentoService(PreprocessamentoRepository preprocessamentoRepository) {
        this.preprocessamentoRepository = preprocessamentoRepository;
    }

    @Transactional
    void preprocessar(ProcessamentoRequestDTO processamentoRequestDTO) {
        this.preprocessamentoRepository.save(PreprocessamentoEntity.getToEntity(processamentoRequestDTO));
    }

    public PreprocessamentoResponseDTO acompanharProcessamento() {
        return new PreprocessamentoResponseDTO();
    }

    public String upload(List<MultipartFile> multipartFileList) {
        multipartFileList.stream().forEach( multipartFile -> {
            try {
                Files.copy(multipartFile.getInputStream(),
                    Paths.get(diretorioUpload)
                            .resolve(this.gerarNomeArquivo(multipartFile)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return "Arquivo Armazenado com Sucesso!";
    }

    private String gerarNomeArquivo(MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        if (multipartFile.isEmpty() || originalFileName == null) {
            throw new IllegalArgumentException("Arquivo inválido");
        }
        return UUID.randomUUID().toString().concat(
                Objects.requireNonNull(originalFileName.substring(originalFileName.lastIndexOf("."))));
    }

}

package br.com.quintinno.mendaciuumapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.quintinno.mendaciuumapi.dto.PreprocessamentoResponseDTO;
import br.com.quintinno.mendaciuumapi.dto.ProcessamentoRequestDTO;
import br.com.quintinno.mendaciuumapi.dto.ProcessamentoResponseDTO;
import br.com.quintinno.mendaciuumapi.service.PreprocessamentoService;
import br.com.quintinno.mendaciuumapi.service.ProcessamentoService;

@RestController
@RequestMapping("/processamento")
public class ProcessamentoController {

    private ProcessamentoService processamentoService;

    private PreprocessamentoService preprocessamentoService;

    public ProcessamentoController(ProcessamentoService processamentoService,
            PreprocessamentoService preprocessamentoService) {
        this.processamentoService = processamentoService;
        this.preprocessamentoService = preprocessamentoService;
    }

    @PostMapping
    public ResponseEntity<ProcessamentoResponseDTO> preprocessamento(@RequestBody List<ProcessamentoRequestDTO> processamentoRequestTransferList) {
        return ResponseEntity.ok().body(this.processamentoService.preprocessamento(processamentoRequestTransferList));
    }

    @GetMapping("/{numeroProtocolo}")
    public ResponseEntity<PreprocessamentoResponseDTO> acompanharProcessamento(@PathVariable String numeroProtocolo) {
        return ResponseEntity.ok().body(this.processamentoService.acompanharProcessamento(numeroProtocolo));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("arquivo") List<MultipartFile> multipartFileList) {
        return ResponseEntity.ok().body(this.preprocessamentoService.upload(multipartFileList));
    }

}

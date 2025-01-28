package br.com.quintinno.mendaciuumapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.mendaciuumapi.service.ProcessamentoService;
import br.com.quintinno.mendaciuumapi.transfer.ProcessamentoRequestTransfer;

@RestController
@RequestMapping("/processamento")
public class ProcessamentoController {

    private ProcessamentoService processamentoService;

    public ProcessamentoController(ProcessamentoService processamentoService) {
        this.processamentoService = processamentoService;
    }

    @PostMapping
    public ResponseEntity<String> processamento(@RequestBody List<ProcessamentoRequestTransfer> processamentoRequestTransferList) {
        return ResponseEntity.ok().body(this.processamentoService.processarDados(processamentoRequestTransferList));
    }

}

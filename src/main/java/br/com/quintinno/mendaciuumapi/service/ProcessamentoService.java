package br.com.quintinno.mendaciuumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintinno.mendaciuumapi.entity.PessoaEntity;
import br.com.quintinno.mendaciuumapi.enumeration.TipoPessoaEnumeration;
import br.com.quintinno.mendaciuumapi.transfer.ProcessamentoRequestTransfer;
import br.com.quintinno.mendaciuumapi.utility.DateUtility;

@Service
public class ProcessamentoService {

    private PessoaService pessoaService;

    public ProcessamentoService(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public String processarDados(List<ProcessamentoRequestTransfer> processamentoRequestTransferList) {
        // Armazenar dados da pessoa
        processamentoRequestTransferList.stream().forEach( processamentoRequestTransfer -> {
            PessoaEntity pessoaEntity = new PessoaEntity();
                pessoaEntity.setTipoPessoaEnumeration(TipoPessoaEnumeration.PESSOA_FISICA);
                pessoaEntity.setNome(processamentoRequestTransfer.getNome());
                pessoaEntity.setNomeMae(processamentoRequestTransfer.getNomeMae());
                pessoaEntity.setNomePai(processamentoRequestTransfer.getNomePai());
                pessoaEntity.setDataNascimento(DateUtility.getData(processamentoRequestTransfer.getDataNascimento(), DateUtility.getFormatoDDMMYYYY()));
            this.pessoaService.create(pessoaEntity);
        });
        return "Dados Processados com Sucesso!";
    }

}

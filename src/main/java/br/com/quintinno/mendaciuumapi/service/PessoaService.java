package br.com.quintinno.mendaciuumapi.service;

import org.springframework.stereotype.Service;

import br.com.quintinno.mendaciuumapi.entity.PessoaEntity;
import br.com.quintinno.mendaciuumapi.repository.PessoaRepostory;

@Service
public class PessoaService {

    private PessoaRepostory pessoaRepostory;

    public PessoaService(PessoaRepostory pessoaRepostory) {
        this.pessoaRepostory = pessoaRepostory;
    }
    
    public PessoaEntity create(PessoaEntity pessoaEntity) {
        return this.pessoaRepostory.save(pessoaEntity);
    }

}

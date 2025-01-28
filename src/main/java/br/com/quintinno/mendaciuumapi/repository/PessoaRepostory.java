package br.com.quintinno.mendaciuumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinno.mendaciuumapi.entity.PessoaEntity;

@Repository
public interface PessoaRepostory extends JpaRepository<PessoaEntity, Long> {}

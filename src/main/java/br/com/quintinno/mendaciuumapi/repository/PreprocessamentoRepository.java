package br.com.quintinno.mendaciuumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinno.mendaciuumapi.entity.PreprocessamentoEntity;


@Repository
public interface PreprocessamentoRepository extends JpaRepository<PreprocessamentoEntity, Long> {
    public List<PreprocessamentoEntity> findByNumeroProtocolo(String numeroProtocolo);
}

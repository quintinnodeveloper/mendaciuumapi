package br.com.quintinno.mendaciuumapi.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import br.com.quintinno.mendaciuumapi.entity.PessoaEntity;
import br.com.quintinno.mendaciuumapi.entity.PreprocessamentoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ProcessamentoImplementacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Set<PreprocessamentoEntity> findPreprocessamentoBatch(String situacao, int limmite) {
        StringBuilder sql = new StringBuilder("SELECT * ")
            .append("FROM tb_preprocessamento preprocessamento ")
            .append("WHERE preprocessamento.tipo_situacao_processamento = :situacao ")
            .append("LIMIT ").append(limmite);
        Query query = this.entityManager.createNativeQuery(sql.toString(), PreprocessamentoEntity.class);
            query.setParameter("situacao", situacao);
        List<PreprocessamentoEntity> preprocessamentoList = query.getResultList();
        return new HashSet<>(preprocessamentoList);
    }

    public boolean isPessoaCadastrada(String nome) {
        StringBuilder sql = new StringBuilder("SELECT * ")
            .append("FROM tb_pessoa pessoa ")
            .append("WHERE UPPER(pessoa.nome) = UPPER(:nome) ");
        Query query = this.entityManager.createNativeQuery(sql.toString(), PessoaEntity.class);
            query.setParameter("nome", nome);
        List<PessoaEntity> pessoaList = query.getResultList();
        return pessoaList.size() > 0;
    }

}

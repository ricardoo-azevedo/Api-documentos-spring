package br.com.ricardoo_azevedo.api_documentos_spring.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ricardoo_azevedo.api_documentos_spring.models.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

    Optional<Escola> findByNome(String nome);

    boolean existsByNome(String nome);

    @Query(value = "SELECT * FROM TB_ESCOLA WHERE nome_escola LIKE CONCAT('%', :nome, '%')", nativeQuery = true)
    List<Escola> findByNomeEscola(@Param("nome") String nome);

}

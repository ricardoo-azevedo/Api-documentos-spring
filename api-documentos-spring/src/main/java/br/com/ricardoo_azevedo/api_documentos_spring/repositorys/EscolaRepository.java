package br.com.ricardoo_azevedo.api_documentos_spring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ricardoo_azevedo.api_documentos_spring.models.Escola;



@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long>{

    Escola findByNome(String nome);

    boolean existsByNome(String nome);

    void deleteByNome(String nome);

}

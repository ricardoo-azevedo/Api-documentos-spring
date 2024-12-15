package br.com.ricardoo_azevedo.api_documentos_spring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ricardoo_azevedo.api_documentos_spring.models.EtapaEnsino;

@Repository
public interface EtapaEnsinoRepository extends JpaRepository<EtapaEnsino, Long>{

    
}

package br.com.ricardoo_azevedo.api_documentos_spring.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ricardoo_azevedo.api_documentos_spring.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    boolean existsByNomeCompleto(String nome);

    Optional<Usuario> findByNomeCompleto(String nome);
}
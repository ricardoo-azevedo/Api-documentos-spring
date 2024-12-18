package br.com.ricardoo_azevedo.api_documentos_spring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoo_azevedo.api_documentos_spring.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    
}
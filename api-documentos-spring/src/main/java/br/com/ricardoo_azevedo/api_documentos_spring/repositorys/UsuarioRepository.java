package br.com.ricardoo_azevedo.api_documentos_spring.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.ricardoo_azevedo.api_documentos_spring.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    boolean existsByNomeCompleto(String nome);

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);

    Optional<Usuario> findByNomeCompleto(String nome);

    @Query(value = "SELECT * FROM TB_USUARIO WHERE nome_completo_usuario LIKE CONCAT('%', :nome, '%')", nativeQuery = true)
    List<Usuario> findByNomeCompletoUsuario(@Param("nome") String nome);
}
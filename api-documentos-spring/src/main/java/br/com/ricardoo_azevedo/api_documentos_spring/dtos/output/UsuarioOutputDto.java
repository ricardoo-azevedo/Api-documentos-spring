package br.com.ricardoo_azevedo.api_documentos_spring.dtos.output;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioOutputDto{

    private Long id;

    private String nomeCompleto;

    private String email;

    private String senha;

    private Timestamp dataCriacao;
}
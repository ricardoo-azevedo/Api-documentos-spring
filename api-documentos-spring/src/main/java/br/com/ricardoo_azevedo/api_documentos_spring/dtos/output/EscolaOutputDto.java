package br.com.ricardoo_azevedo.api_documentos_spring.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class EscolaOutputDto {
    
    private Long id;

    private String nome;

    private String tipoEscola;
}

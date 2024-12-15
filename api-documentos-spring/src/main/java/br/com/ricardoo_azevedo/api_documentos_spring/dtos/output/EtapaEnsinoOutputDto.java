package br.com.ricardoo_azevedo.api_documentos_spring.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EtapaEnsinoOutputDto {
    
    private Long id;

    private String tipoEnsino;

    private String subTipoEnsino;
}

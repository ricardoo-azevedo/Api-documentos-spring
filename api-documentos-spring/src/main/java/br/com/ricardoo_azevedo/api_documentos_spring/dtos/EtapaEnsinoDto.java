package br.com.ricardoo_azevedo.api_documentos_spring.dtos;

import br.com.ricardoo_azevedo.api_documentos_spring.config.annotations.EnumPattern;
import br.com.ricardoo_azevedo.api_documentos_spring.models.EtapaEnsino.SubTipoEnsino;
import br.com.ricardoo_azevedo.api_documentos_spring.models.EtapaEnsino.TipoEnsino;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EtapaEnsinoDto {
    
    public EtapaEnsinoDto(String tipoEnsino, String subTipoEnsino){
        this.tipoEnsino = tipoEnsino;
        this.subTipoEnsino = subTipoEnsino;
    }

    
    private Long id;
    
    @EnumPattern(enumClass = TipoEnsino.class, message = "Valor invalido! Valores aceitos: Fundamental, Médio")
    @NotNull
    private String tipoEnsino;

    @EnumPattern(enumClass = SubTipoEnsino.class, message = "Valor invalido! Valores aceitos: Regular, Travessia, Eja")
    @NotNull
    private String subTipoEnsino;
}

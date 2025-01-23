package br.com.ricardoo_azevedo.api_documentos_spring.dtos;

import br.com.ricardoo_azevedo.api_documentos_spring.config.annotations.EnumPattern;
import br.com.ricardoo_azevedo.api_documentos_spring.models.Escola.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class EscolaDto {

    public EscolaDto(String nome, String tipoEscola){
        this.nome = nome;
        this.tipoEscola = tipoEscola;

    }

    private Long id;
    
    @NotBlank(message = "O Nome não deve ser nulo")
    private String nome;

    @EnumPattern(enumClass = Tipo.class, message = "valor invalido! Valores aceitos: Pública, Privada")
    @NotNull(message = "O Tipo não deve ser nulo!")
    private String tipoEscola;
}

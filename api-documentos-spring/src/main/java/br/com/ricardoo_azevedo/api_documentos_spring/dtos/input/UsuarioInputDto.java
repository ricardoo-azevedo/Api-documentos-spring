package br.com.ricardoo_azevedo.api_documentos_spring.dtos.input;

import br.com.ricardoo_azevedo.api_documentos_spring.config.annotations.EnumPattern;
import br.com.ricardoo_azevedo.api_documentos_spring.models.Usuario.UsuarioRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UsuarioInputDto{

    @NotBlank(message = "Nome precisa ser incluso")
    @Size(max = 225, message = "Ultrapassou o limite maximo de caracteres!")
    private String nomeCompleto;

    @NotBlank(message = "Email precisa ser incluso")
    @Size(max = 225, min = 8, message = "Ultrapassou o limite maximo de caracteres = 225 ou o limite minimo = 8!")
    private String email;

    @NotBlank(message = "Senha precisa ser incluso")
    @Size(max = 225, min = 8, message = "Ultrapassou o limite maximo de caracteres = 225 ou o limite minimo = 8!")
    private String senha;

    @EnumPattern(enumClass = UsuarioRole.class, message = "Valores invalidos! Valores aceitos: Admin, Usuario")
    @NotNull
    private String role;
}
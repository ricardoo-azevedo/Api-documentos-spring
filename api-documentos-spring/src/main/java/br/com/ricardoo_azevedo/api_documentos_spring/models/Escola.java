package br.com.ricardoo_azevedo.api_documentos_spring.models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Component
@Table(name = "tb_escola")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Escola {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_escola", unique = true, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_escola", nullable = false, columnDefinition = "ENUM('Pública', 'Privada')")
    private Tipo tipoEscola;

    
    public enum Tipo{
        PÚBLICA,
        PRIVADA
    }
}

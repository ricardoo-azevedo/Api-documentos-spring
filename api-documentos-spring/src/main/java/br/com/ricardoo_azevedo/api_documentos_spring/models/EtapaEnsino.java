package br.com.ricardoo_azevedo.api_documentos_spring.models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component
@Table(name = "tb_etapa_ensino")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class EtapaEnsino {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_ensino", nullable = false, columnDefinition = "ENUM('Fundamental', 'Médio')")
    private TipoEnsino tipoEnsino;

    @Column(name = "sub_tipo_ensino", nullable = false, columnDefinition = "ENUM('Regular', 'Eja', 'Travessia')")
    private SubTipoEnsino subTipoEnsino;


    public enum TipoEnsino{
        Fundamental,
        Médio
    }

    public enum SubTipoEnsino{
        Regular,
        Eja,
        Travessia
    }
}

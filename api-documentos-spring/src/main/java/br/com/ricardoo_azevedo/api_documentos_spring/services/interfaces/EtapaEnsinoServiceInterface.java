package br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces;

import java.util.List;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.EtapaEnsinoInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.EtapaEnsinoOutputDto;

public interface EtapaEnsinoServiceInterface {

    EtapaEnsinoOutputDto salvar(EtapaEnsinoInputDto etapaEnsinoInputDto);

    EtapaEnsinoOutputDto editar(EtapaEnsinoOutputDto etapaEnsinoOutputDto);

    List<EtapaEnsinoOutputDto> listar();

    EtapaEnsinoOutputDto pesquisar(Long id);

    void deletar(Long id);
    
} 

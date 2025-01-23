package br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces;

import java.util.List;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.EtapaEnsinoDto;



public interface EtapaEnsinoServiceInterface {

    EtapaEnsinoDto salvar(EtapaEnsinoDto etapaEnsinoInputDto);

    EtapaEnsinoDto editar(EtapaEnsinoDto etapaEnsinoInputDto, Long id);

    List<EtapaEnsinoDto> listar();

    EtapaEnsinoDto pesquisar(Long id);

    void deletar(Long id);
    
} 

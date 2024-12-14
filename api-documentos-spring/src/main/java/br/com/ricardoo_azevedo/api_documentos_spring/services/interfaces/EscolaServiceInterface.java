package br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces;
import java.util.List;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.EscolaInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.EscolaOutputDto;

public interface EscolaServiceInterface {

    EscolaOutputDto salvar(EscolaInputDto escolaDto);

    EscolaOutputDto editarPorId(EscolaInputDto escolaDto, Long id);

    EscolaOutputDto editarPorNome(EscolaInputDto escolaDto, String nomeAntigo);

    List<EscolaOutputDto> listar();

    EscolaOutputDto pesquisarPorId(Long id);

    List<EscolaOutputDto> pesquisarPorNome(String nome);

    void deletarPorId(Long id);

} 

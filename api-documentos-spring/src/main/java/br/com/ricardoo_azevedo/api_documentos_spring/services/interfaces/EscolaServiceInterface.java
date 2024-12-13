package br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces;
import java.util.List;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.EscolaDto;

public interface EscolaServiceInterface {

    EscolaDto salvar(EscolaDto escolaDto);

    EscolaDto editarPorId(EscolaDto escolaDto, Long id);

    EscolaDto editarPorNome(EscolaDto escolaDto, String nomeAntigo);

    List<EscolaDto> listar();

    EscolaDto pesquisarPorId(Long id);

    EscolaDto pesquisarPorNome(String nome);

    void deletarPorId(Long id);

    void deletarPorNome(String nome);

} 

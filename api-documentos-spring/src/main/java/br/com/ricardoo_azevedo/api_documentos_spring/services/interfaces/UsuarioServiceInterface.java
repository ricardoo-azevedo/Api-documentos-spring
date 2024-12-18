package br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces;

import java.util.List;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.UsuarioInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.UsuarioOutputDto;

public interface UsuarioServiceInterface{

    UsuarioOutputDto salvar(UsuarioInputDto UsuarioInputDto);

    UsuarioOutputDto editarPorId(UsuarioInputDto UsuarioInputDto, Long id);

    UsuarioOutputDto editarPorNome(UsuarioInputDto UsuarioInputDto, String nome);

    List<UsuarioOutputDto> listar();

    UsuarioOutputDto pesquisarPorId(Long id);

    List<UsuarioOutputDto> pesquisarPorNome(String nome);

    void deletarPorId(Long id);

}
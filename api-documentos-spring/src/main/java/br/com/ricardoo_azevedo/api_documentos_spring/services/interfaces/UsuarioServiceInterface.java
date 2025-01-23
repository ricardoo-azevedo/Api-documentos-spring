package br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces;

import java.util.List;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.UsuarioDto;


public interface UsuarioServiceInterface{

    UsuarioDto salvar(UsuarioDto UsuarioInputDto);

    UsuarioDto editarPorId(UsuarioDto UsuarioInputDto, Long id);

    UsuarioDto editarPorNome(UsuarioDto UsuarioInputDto, String nome);

    List<UsuarioDto> listar();

    UsuarioDto pesquisarPorId(Long id);

    List<UsuarioDto> pesquisarPorNome(String nome);

    void deletarPorId(Long id);

}
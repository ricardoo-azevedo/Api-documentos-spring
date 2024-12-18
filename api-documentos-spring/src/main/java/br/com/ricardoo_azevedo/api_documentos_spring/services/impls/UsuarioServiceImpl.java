package br.com.ricardoo_azevedo.api_documentos_spring.services.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.UsuarioInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.UsuarioOutputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces.UsuarioServiceInterface;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface{

    @Override
    public UsuarioOutputDto salvar(UsuarioInputDto UsuarioInputDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public UsuarioOutputDto editarPorId(UsuarioInputDto UsuarioInputDto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarPorId'");
    }

    @Override
    public UsuarioOutputDto editarPorNome(UsuarioInputDto UsuarioInputDto, String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarPorNome'");
    }

    @Override
    public List<UsuarioOutputDto> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public UsuarioOutputDto pesquisarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarPorId'");
    }

    @Override
    public List<UsuarioOutputDto> pesquisarPorNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarPorNome'");
    }

    @Override
    public void deletarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarPorId'");
    }

}
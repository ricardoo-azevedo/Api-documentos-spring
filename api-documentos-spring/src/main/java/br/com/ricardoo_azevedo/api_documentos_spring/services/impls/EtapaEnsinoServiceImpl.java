package br.com.ricardoo_azevedo.api_documentos_spring.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.EtapaEnsinoInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.EtapaEnsinoOutputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.repositorys.EtapaEnsinoRepository;
import br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces.EtapaEnsinoServiceInterface;

@Service
public class EtapaEnsinoServiceImpl implements EtapaEnsinoServiceInterface{

    @Autowired
    private EtapaEnsinoRepository etapaEnsinoRepository;

    @Override
    public EtapaEnsinoOutputDto salvar(EtapaEnsinoInputDto etapaEnsinoInputDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public EtapaEnsinoOutputDto editar(EtapaEnsinoOutputDto etapaEnsinoOutputDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }

    @Override
    public List<EtapaEnsinoOutputDto> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public EtapaEnsinoOutputDto pesquisar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisar'");
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}

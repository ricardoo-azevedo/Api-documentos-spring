package br.com.ricardoo_azevedo.api_documentos_spring.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.EtapaEnsinoInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.EtapaEnsinoOutputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.EtapaEnsinoNaoEncontradaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.IdInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.ListaVaziaException;
import br.com.ricardoo_azevedo.api_documentos_spring.models.EtapaEnsino;
import br.com.ricardoo_azevedo.api_documentos_spring.models.EtapaEnsino.SubTipoEnsino;
import br.com.ricardoo_azevedo.api_documentos_spring.models.EtapaEnsino.TipoEnsino;
import br.com.ricardoo_azevedo.api_documentos_spring.repositorys.EtapaEnsinoRepository;
import br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces.EtapaEnsinoServiceInterface;

@Service
public class EtapaEnsinoServiceImpl implements EtapaEnsinoServiceInterface {

    @Autowired
    private EtapaEnsinoRepository etapaEnsinoRepository;

    @Override
    public EtapaEnsinoOutputDto salvar(EtapaEnsinoInputDto etapaEnsinoInputDto) {
        EtapaEnsino etapaEnsino = new EtapaEnsino();
        etapaEnsino.setTipoEnsino(TipoEnsino.valueOf(etapaEnsinoInputDto.getTipoEnsino()));
        etapaEnsino.setSubTipoEnsino(SubTipoEnsino.valueOf(etapaEnsinoInputDto.getSubTipoEnsino()));
        EtapaEnsino etapaSalva = etapaEnsinoRepository.save(etapaEnsino);
        return new EtapaEnsinoOutputDto(
                etapaSalva.getId(),
                etapaSalva.getTipoEnsino().toString(),
                etapaSalva.getSubTipoEnsino().toString());
    }

    @Override
    public EtapaEnsinoOutputDto editar(EtapaEnsinoInputDto etapaEnsinoInputDto, Long id) {
        if (id == null) {
            throw new IdInvalidoException("O id esta Nulo!");
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        EtapaEnsino etapaEnsino = etapaEnsinoRepository.findById(id)
                .orElseThrow(() -> new EtapaEnsinoNaoEncontradaException());
        etapaEnsino.setTipoEnsino(TipoEnsino.valueOf(etapaEnsinoInputDto.getTipoEnsino()));
        etapaEnsino.setSubTipoEnsino(SubTipoEnsino.valueOf(etapaEnsinoInputDto.getSubTipoEnsino()));
        EtapaEnsino etapaEditada = etapaEnsinoRepository.save(etapaEnsino);
        return new EtapaEnsinoOutputDto(
                etapaEditada.getId(),
                etapaEditada.getTipoEnsino().toString(),
                etapaEditada.getSubTipoEnsino().toString());

    }

    @Override
    public List<EtapaEnsinoOutputDto> listar() {
        List<EtapaEnsino> etapaEnsinos = etapaEnsinoRepository.findAll();
        if (etapaEnsinos.isEmpty()) {
            throw new ListaVaziaException();
        }
        return etapaEnsinos.stream().map(
                etapaEnsino -> new EtapaEnsinoOutputDto(
                        etapaEnsino.getId(),
                        etapaEnsino.getTipoEnsino().toString(),
                        etapaEnsino.getSubTipoEnsino().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public EtapaEnsinoOutputDto pesquisar(Long id) {
        if (id == null) {
            throw new IdInvalidoException("O id esta Nulo!");
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        return etapaEnsinoRepository.findById(id).map(
                etapaEnsino -> new EtapaEnsinoOutputDto(
                        etapaEnsino.getId(),
                        etapaEnsino.getTipoEnsino().toString(),
                        etapaEnsino.getSubTipoEnsino().toString()
                )).orElseThrow(() -> new EtapaEnsinoNaoEncontradaException());
    }

    @Override
    public void deletar(Long id) {
        if (id == null) {
            throw new IdInvalidoException("O id esta Nulo!");
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        if(etapaEnsinoRepository.existsById(id) == false){
            throw new EtapaEnsinoNaoEncontradaException();
        }
        etapaEnsinoRepository.deleteById(id);
    }

}

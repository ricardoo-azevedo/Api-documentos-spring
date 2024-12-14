package br.com.ricardoo_azevedo.api_documentos_spring.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.EscolaInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.EscolaOutputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.EscolaJaCadastradaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.EscolaNaoEncontradaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.IdInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.ListaVaziaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.NomeInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.models.Escola;
import br.com.ricardoo_azevedo.api_documentos_spring.models.Escola.Tipo;
import br.com.ricardoo_azevedo.api_documentos_spring.repositorys.EscolaRepository;
import br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces.EscolaServiceInterface;
@Service
public class EscolaServiceImpl implements EscolaServiceInterface {

    @Autowired
    EscolaRepository escolaRepository;

    @Override
    public EscolaOutputDto salvar(EscolaInputDto escolaDto) {
        Escola escola = new Escola();
        if (escolaRepository.existsByNome(escolaDto.getNome())) {
            throw new EscolaJaCadastradaException();
        }
        escola.setNome(escolaDto.getNome());
        escola.setTipoEscola(Tipo.valueOf(escolaDto.getTipoEscola()));
        Escola escolaSalva = escolaRepository.save(escola);
        
        return new EscolaOutputDto(escolaSalva.getId(), escolaSalva.getNome(), escolaSalva.getTipoEscola().toString());
    }

    @Override
    public EscolaOutputDto editarPorId(EscolaInputDto escolaDto, Long id) {
        if (id == null) {
            throw new IdInvalidoException("O id esta nulo!");
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        Escola escola = escolaRepository.findById(id).orElseThrow(()-> new EscolaNaoEncontradaException());
        if (escolaRepository.existsByNome(escolaDto.getNome())) {
            throw new EscolaJaCadastradaException();
        }
        escola.setNome(escolaDto.getNome());
        escola.setTipoEscola(Tipo.valueOf(escolaDto.getTipoEscola()));
        Escola escolaEditada = escolaRepository.save(escola);
        return new EscolaOutputDto(
                escolaEditada.getId(),
                escolaEditada.getNome(),
                escolaEditada.getTipoEscola().toString());

    }

    @Override
    public EscolaOutputDto editarPorNome(EscolaInputDto escolaDto, String nomeAntigo) {
        if (nomeAntigo.isBlank()) {
            throw new NomeInvalidoException();
        }
        Escola escola = escolaRepository.findByNome(nomeAntigo).orElseThrow(()->new EscolaNaoEncontradaException());
        
        if (escolaRepository.existsByNome(escolaDto.getNome())) {
            throw new EscolaJaCadastradaException();
        }
        escola.setNome(escolaDto.getNome());
        escola.setTipoEscola(Tipo.valueOf(escolaDto.getTipoEscola()));
        Escola escolaEditada = escolaRepository.save(escola);
        return new EscolaOutputDto(
                escolaEditada.getId(),
                escolaEditada.getNome(),
                escolaEditada.getTipoEscola().toString());
    }

    @Override
    public List<EscolaOutputDto> listar() {
        List<Escola> escolas = escolaRepository.findAll();
        if (escolas.isEmpty()) {
            throw new ListaVaziaException();
        }
        return escolas.stream().map(
                escola -> new EscolaOutputDto(
                        escola.getId(),
                        escola.getNome(),
                        escola.getTipoEscola().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public EscolaOutputDto pesquisarPorNome(String nome) {
        Escola escola = null;
        escola = escolaRepository.findByNome(nome).orElseThrow(()->new EscolaNaoEncontradaException());
        return new EscolaOutputDto(
                escola.getId(),
                escola.getNome(),
                escola.getTipoEscola().toString());
    }

    @Override
    public EscolaOutputDto pesquisarPorId(Long id) {
        if (id == null) {
            throw new IdInvalidoException("O id é nulo");
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        return escolaRepository.findById(id)
                .map(escola -> new EscolaOutputDto(
                        escola.getId(),
                        escola.getNome(),
                        escola.getTipoEscola().toString()))
                .orElseThrow(()-> new EscolaNaoEncontradaException());
    }

    @Override
    public void deletarPorId(Long id) {
        if (id == null) {
            throw new IdInvalidoException("O id é nulo");
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        if (escolaRepository.existsById(id) == false) {
            throw new EscolaNaoEncontradaException();
        }
        escolaRepository.deleteById(id);
    }

}

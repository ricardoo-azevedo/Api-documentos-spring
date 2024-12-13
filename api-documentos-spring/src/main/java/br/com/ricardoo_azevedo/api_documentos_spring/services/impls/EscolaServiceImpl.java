package br.com.ricardoo_azevedo.api_documentos_spring.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.EscolaDto;
import br.com.ricardoo_azevedo.api_documentos_spring.models.Escola;
import br.com.ricardoo_azevedo.api_documentos_spring.models.Escola.Tipo;
import br.com.ricardoo_azevedo.api_documentos_spring.repositorys.EscolaRepository;
import br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces.EscolaServiceInterface;

@Service
public class EscolaServiceImpl implements EscolaServiceInterface {

    @Autowired
    EscolaRepository escolaRepository;

    @Override
    public EscolaDto salvar(EscolaDto escolaDto) {
        Escola escola = new Escola();
        if (escolaRepository.existsByNome(escolaDto.getNome())) {
            // validacao
        }
        escola.setNome(escolaDto.getNome());
        escola.setTipoEscola(Tipo.valueOf(escolaDto.getTipoEscola()));
        Escola escolaSalva = escolaRepository.save(escola);
        return new EscolaDto(
                escolaSalva.getNome(),
                escolaSalva.getTipoEscola().toString());
    }

    @Override
    public EscolaDto editarPorId(EscolaDto escolaDto, Long id) {
        if (id == null) {
            // validacao
        }
        if (!(id instanceof Long)) {
            // validacao
        }
        Escola escola = escolaRepository.findById(id).orElseThrow(); // validacao
        if (escolaRepository.existsByNome(escolaDto.getNome())) {
            // validacao
        }
        escola.setNome(escolaDto.getNome());
        escola.setTipoEscola(Tipo.valueOf(escolaDto.getTipoEscola()));
        Escola escolaEditada = escolaRepository.save(escola);
        return new EscolaDto(
                escolaEditada.getNome(),
                escolaEditada.getTipoEscola().toString());

    }

    @Override
    public EscolaDto editarPorNome(EscolaDto escolaDto, String nomeAntigo) {
        if (nomeAntigo.isBlank()) {
            // validacao
        }
        Escola escola = null;
        try {
            escola = escolaRepository.findByNome(nomeAntigo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (escolaRepository.existsByNome(escolaDto.getNome())) {
            // validacao
        }
        escola.setNome(escolaDto.getNome());
        escola.setTipoEscola(Tipo.valueOf(escolaDto.getTipoEscola()));
        Escola escolaEditada = escolaRepository.save(escola);
        return new EscolaDto(
                escolaEditada.getNome(),
                escolaEditada.getTipoEscola().toString());
    }

    @Override
    public List<EscolaDto> listar() {
        List<Escola> escolas = escolaRepository.findAll();
        if (escolas.isEmpty()) {
            // validação
        }
        return escolas.stream().map(
                escola -> new EscolaDto(
                        escola.getNome(),
                        escola.getTipoEscola().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public EscolaDto pesquisarPorNome(String nome) {
        Escola escola = null;
        try {
            escola = escolaRepository.findByNome(nome);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new EscolaDto(
                escola.getNome(),
                escola.getTipoEscola().toString());
    }

    @Override
    public EscolaDto pesquisarPorId(Long id) {
        if (id == null) {
            // validacao
        }
        if (!(id instanceof Long)) {
            // validacao
        }
        return escolaRepository.findById(id)
                .map(escola -> new EscolaDto(
                        escola.getNome(),
                        escola.getTipoEscola().toString()))
                .orElseThrow(); // validação
    }

    @Override
    public void deletarPorId(Long id) {
        if (id == null) {
            // validacao
        }
        if (!(id instanceof Long)) {
            // validacao
        }
        if (escolaRepository.existsById(id) == false) {
            // validacao
        }
        try {
            escolaRepository.deleteById(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deletarPorNome(String nome) {
        if (nome.isBlank()) {
            // validacao
        }
        if (nome.isBlank()) {
            // validacao
        }
        try {
            escolaRepository.deleteByNome(nome);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

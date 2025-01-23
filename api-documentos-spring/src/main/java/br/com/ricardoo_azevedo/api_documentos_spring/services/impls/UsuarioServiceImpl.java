package br.com.ricardoo_azevedo.api_documentos_spring.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.UsuarioDto;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.EmailJaCadastradoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.IdInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.ListaVaziaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.NomeInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.UsuarioJaCadastradoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.UsuarioNaoEncontradoException;
import br.com.ricardoo_azevedo.api_documentos_spring.models.Usuario;
import br.com.ricardoo_azevedo.api_documentos_spring.repositorys.UsuarioRepository;
import br.com.ricardoo_azevedo.api_documentos_spring.services.interfaces.UsuarioServiceInterface;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioInputDto) {
        Usuario usuario = new Usuario();
        if (usuarioRepository.existsByNomeCompleto(usuarioInputDto.getNomeCompleto())) {
            throw new UsuarioJaCadastradoException();
        }
        usuario.setNomeCompleto(usuarioInputDto.getNomeCompleto());
        if(usuarioRepository.existsByEmail(usuarioInputDto.getEmail())){
            throw new EmailJaCadastradoException();
        }
        usuario.setEmail(usuarioInputDto.getEmail());
        usuario.setSenha(usuarioInputDto.getSenha());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioDto(
                usuarioSalvo.getId(),
                usuarioSalvo.getNomeCompleto(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getSenha(),
                usuarioSalvo.getRole().toString(),
                usuarioSalvo.getData_criacao());

    }

    @Override
    public UsuarioDto editarPorId(UsuarioDto usuarioInputDto, Long id) {
        if (id == null) {
            throw new IdInvalidoException();
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException());
        if (usuarioRepository.existsByNomeCompleto(usuarioInputDto.getNomeCompleto())) {
            throw new UsuarioJaCadastradoException();
        }
        usuario.setNomeCompleto(usuarioInputDto.getNomeCompleto());
        if(usuarioRepository.existsByEmail(usuarioInputDto.getEmail())){
            throw new EmailJaCadastradoException();
        }
        usuario.setEmail(usuarioInputDto.getEmail());
        usuario.setSenha(usuarioInputDto.getSenha());
        Usuario usuarioEditado = usuarioRepository.save(usuario);
        return new UsuarioDto(
                usuarioEditado.getId(),
                usuarioEditado.getNomeCompleto(),
                usuarioEditado.getEmail(),
                usuarioEditado.getSenha(),
                usuarioEditado.getRole().toString(),
                usuarioEditado.getData_criacao());
    }

    @Override
    public UsuarioDto editarPorNome(UsuarioDto usuarioInputDto, String nomeAntigo) {
        if (nomeAntigo.isBlank()) {
            throw new NomeInvalidoException();
        }
        Usuario usuario = usuarioRepository.findByNomeCompleto(nomeAntigo)
                .orElseThrow(() -> new UsuarioNaoEncontradoException());
        if (usuarioRepository.existsByNomeCompleto(usuarioInputDto.getNomeCompleto())) {
            throw new UsuarioJaCadastradoException();
        }
        usuario.setNomeCompleto(usuarioInputDto.getNomeCompleto());
        if(usuarioRepository.existsByEmail(usuarioInputDto.getEmail())){
            throw new EmailJaCadastradoException();
        }
        usuario.setEmail(usuarioInputDto.getEmail());
        usuario.setSenha(usuarioInputDto.getSenha());
        Usuario usuarioEditado = usuarioRepository.save(usuario);
        return new UsuarioDto(
                usuarioEditado.getId(),
                usuarioEditado.getNomeCompleto(),
                usuarioEditado.getEmail(),
                usuarioEditado.getSenha(),
                usuarioEditado.getRole().toString(),
                usuarioEditado.getData_criacao());

    }

    @Override
    public List<UsuarioDto> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new ListaVaziaException();
        }
        return usuarios.stream().map(
                usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNomeCompleto(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario.getRole().toString(),
                        usuario.getData_criacao()))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto pesquisarPorId(Long id) {
        if (id == null) {
            throw new IdInvalidoException();
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        return usuarioRepository.findById(id).map(
                usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNomeCompleto(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario.getRole().toString(),
                        usuario.getData_criacao()))
                .orElseThrow(() -> new UsuarioNaoEncontradoException());
    }

    @Override
    public List<UsuarioDto> pesquisarPorNome(String nome) {
        List<Usuario> resultados = usuarioRepository.findByNomeCompletoUsuario(nome);
        if (resultados.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        return resultados.stream().map(
                usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNomeCompleto(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario.getRole().toString(),
                        usuario.getData_criacao()))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        if (id == null) {
            throw new IdInvalidoException();
        }
        if (!(id instanceof Long)) {
            throw new IdInvalidoException();
        }
        if (usuarioRepository.existsById(id) == false) {
            throw new UsuarioNaoEncontradoException();
        }
        usuarioRepository.deleteById(id);
    }

}
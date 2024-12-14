package br.com.ricardoo_azevedo.api_documentos_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.input.EscolaInputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.dtos.output.EscolaOutputDto;
import br.com.ricardoo_azevedo.api_documentos_spring.services.impls.EscolaServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/escola")
public class EscolaController {

    @Autowired
    private EscolaServiceImpl escolaServiceImpl;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid EscolaInputDto escolaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        EscolaOutputDto escolaSalva = escolaServiceImpl.salvar(escolaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(escolaSalva);
    }

    @PutMapping("/editar-por-id={id}")
    public ResponseEntity<?> editarPorId(@RequestBody @Valid EscolaInputDto escolaDto,
            BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        EscolaOutputDto escolaEditada = escolaServiceImpl.editarPorId(escolaDto, id);
        return ResponseEntity.ok().body(escolaEditada);
    }

    @PutMapping("/editar-por-nome={nomeAntigo}")
    public ResponseEntity<?> editarPorNome(@RequestBody @Valid EscolaInputDto escolaDto, BindingResult bindingResult,
            @PathVariable String nomeAntigo) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        EscolaOutputDto escolaEditada = escolaServiceImpl.editarPorNome(escolaDto, nomeAntigo);
        return ResponseEntity.ok().body(escolaEditada);
    }

    @GetMapping
    public ResponseEntity<List<?>> listar() {
        List<EscolaOutputDto> escolaDtos = escolaServiceImpl.listar();
        return ResponseEntity.ok(escolaDtos);
    }

    @GetMapping("/pesquisar-por-id={id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        EscolaOutputDto escolaDto = escolaServiceImpl.pesquisarPorId(id);
        return ResponseEntity.ok().body(escolaDto);
    }

    @GetMapping("/pesquisar-por-nome={nome}")
    public ResponseEntity<?> buscarPorId(@PathVariable String nome) {
        EscolaOutputDto escolaDto = escolaServiceImpl.pesquisarPorNome(nome);
        return ResponseEntity.ok().body(escolaDto);
    }

    @DeleteMapping("/deletar-por-id={id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id){
        escolaServiceImpl.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

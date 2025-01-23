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

import br.com.ricardoo_azevedo.api_documentos_spring.dtos.EtapaEnsinoDto;
import br.com.ricardoo_azevedo.api_documentos_spring.services.impls.EtapaEnsinoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/etapa-ensino")
public class EtapaEnsinoController {

    @Autowired
    private EtapaEnsinoServiceImpl ensinoServiceImpl;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid EtapaEnsinoDto etapaEnsinoInputDto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        EtapaEnsinoDto etapaSalva = ensinoServiceImpl.salvar(etapaEnsinoInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(etapaSalva);
    }

    @PutMapping("/editar-por-id={id}")
    public ResponseEntity<?> editar(@RequestBody @Valid EtapaEnsinoDto etapaEnsinoInputDto,
            BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        EtapaEnsinoDto etapaEditada = ensinoServiceImpl.editar(etapaEnsinoInputDto, id);
        return ResponseEntity.ok().body(etapaEditada);
    }

    @GetMapping
    public ResponseEntity<List<?>> listar() {
        List<EtapaEnsinoDto> etapaEnsinoOutputDtos = ensinoServiceImpl.listar();
        return ResponseEntity.ok().body(etapaEnsinoOutputDtos);
    }

    @GetMapping("/pesquisar-por-id={id}")
    public ResponseEntity<?> pesquisar(@PathVariable Long id) {
        EtapaEnsinoDto ensinoOutputDto = ensinoServiceImpl.pesquisar(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(ensinoOutputDto);
    }

    @DeleteMapping("/deletar-por-id={id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        ensinoServiceImpl.deletar(id);
        return ResponseEntity.noContent().build();

    }

}

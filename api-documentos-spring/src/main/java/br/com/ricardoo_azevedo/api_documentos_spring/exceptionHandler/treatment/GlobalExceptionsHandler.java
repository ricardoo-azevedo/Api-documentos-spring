package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.treatment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.EscolaJaCadastradaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.EscolaNaoEncontradaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.EtapaEnsinoNaoEncontradaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.IdInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.ListaVaziaException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.NomeInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.UsuarioJaCadastradoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.UsuarioNaoEncontradoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.formatter.RestErrorMessage;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdInvalidoException.class)
    ResponseEntity<RestErrorMessage> IdInvalidoException(IdInvalidoException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(EscolaNaoEncontradaException.class)
    ResponseEntity<RestErrorMessage> EscolaNaoEncontradaException(EscolaNaoEncontradaException exception) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EscolaJaCadastradaException.class)
    ResponseEntity<RestErrorMessage> EscolaJaCadastradaException(EscolaJaCadastradaException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(response);     
    }

    @ExceptionHandler(NomeInvalidoException.class)
    ResponseEntity<RestErrorMessage> NomeInvalidoException(NomeInvalidoException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);     
    }

    @ExceptionHandler(ListaVaziaException.class)
    ResponseEntity<RestErrorMessage> ListaVaziaException(ListaVaziaException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);     
    }

    @ExceptionHandler(EtapaEnsinoNaoEncontradaException.class)
    ResponseEntity<RestErrorMessage> EtapaEnsinoNaoEncontradaException(EtapaEnsinoNaoEncontradaException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    ResponseEntity<RestErrorMessage> UsuarioNaoEncontradoException(UsuarioNaoEncontradoException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UsuarioJaCadastradoException.class)
    ResponseEntity<RestErrorMessage> EscolaJaCadastradaException(UsuarioJaCadastradoException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(response);     
    }

}

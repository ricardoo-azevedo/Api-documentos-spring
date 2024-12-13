package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.treatment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions.IdInvalidoException;
import br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.formatter.RestErrorMessage;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {

    

}

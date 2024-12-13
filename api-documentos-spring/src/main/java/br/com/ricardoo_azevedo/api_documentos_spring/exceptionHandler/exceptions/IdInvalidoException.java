package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class IdInvalidoException extends RuntimeException{
    public IdInvalidoException(){
        super("O id enviado é invalido!");
    }

    public IdInvalidoException(String message){
        super(message);
    }
}

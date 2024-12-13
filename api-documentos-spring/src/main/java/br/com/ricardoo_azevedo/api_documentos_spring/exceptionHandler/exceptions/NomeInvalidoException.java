package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class NomeInvalidoException extends RuntimeException{
    public NomeInvalidoException(){
        super("O nome passado não é valido");
    }

    public NomeInvalidoException(String message){
        super(message);
    }
}

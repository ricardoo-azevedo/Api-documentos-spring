package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class EscolaNaoEncontradaException extends RuntimeException{
    
    public EscolaNaoEncontradaException(){
        super("Escola não encontrada!");
    }

    public EscolaNaoEncontradaException(String message){
        super(message);
    }
}

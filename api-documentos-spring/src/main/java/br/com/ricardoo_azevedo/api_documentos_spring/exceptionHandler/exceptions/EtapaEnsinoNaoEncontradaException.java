package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class EtapaEnsinoNaoEncontradaException extends RuntimeException{
    
    public EtapaEnsinoNaoEncontradaException(){
        super("Etapa de ensino não encontrada!");
    }

    public EtapaEnsinoNaoEncontradaException(String message){
        super(message);
    }
}

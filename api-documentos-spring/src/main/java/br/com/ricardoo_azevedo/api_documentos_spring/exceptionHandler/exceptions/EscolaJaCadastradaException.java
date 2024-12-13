package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class EscolaJaCadastradaException extends RuntimeException{

    public EscolaJaCadastradaException(){
        super("Essa escola ja esta Cadastrada");
    }
    
    public EscolaJaCadastradaException(String message){
        super(message);
    }
}

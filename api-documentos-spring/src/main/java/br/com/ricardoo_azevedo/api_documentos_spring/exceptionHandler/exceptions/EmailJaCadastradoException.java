package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class EmailJaCadastradoException extends RuntimeException{
    
    public EmailJaCadastradoException(){
        super("O email ja esta cadastrado!");
    }

    public EmailJaCadastradoException(String message){
        super(message);
    }
}

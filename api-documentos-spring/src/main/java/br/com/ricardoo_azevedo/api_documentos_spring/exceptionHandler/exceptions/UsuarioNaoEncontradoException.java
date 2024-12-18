package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
    
    public UsuarioNaoEncontradoException(){
        super("Usuario não encontrado!");
    }

    public UsuarioNaoEncontradoException(String message){
        super(message);
    }
}

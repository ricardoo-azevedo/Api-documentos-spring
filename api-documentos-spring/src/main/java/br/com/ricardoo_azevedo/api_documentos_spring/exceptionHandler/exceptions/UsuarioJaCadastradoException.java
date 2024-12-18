package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class UsuarioJaCadastradoException extends RuntimeException {
    
    public UsuarioJaCadastradoException(){
        super("Usuario já cadastrado!");
    }

    public UsuarioJaCadastradoException(String message){
        super(message);
    }
}

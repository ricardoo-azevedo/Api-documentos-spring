package br.com.ricardoo_azevedo.api_documentos_spring.exceptionHandler.exceptions;

public class ListaVaziaException extends RuntimeException{
    
    public ListaVaziaException(){
        super("A lista se encontra vazia!");
    }

    public ListaVaziaException(String message){
        super(message);
    }
}

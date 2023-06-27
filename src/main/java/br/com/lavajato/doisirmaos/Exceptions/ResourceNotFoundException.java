package br.com.lavajato.doisirmaos.Exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Recurso não encontrado");
    }
}

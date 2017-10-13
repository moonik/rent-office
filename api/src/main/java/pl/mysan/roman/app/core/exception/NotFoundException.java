package pl.mysan.roman.app.core.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(Long id){
        super("Vehicle with id="+id+" not found");
    }
}
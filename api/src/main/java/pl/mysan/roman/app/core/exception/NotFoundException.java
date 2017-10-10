package pl.mysan.roman.app.core.exception;

public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = -3332292346834265371L;

    public NotFoundException(Long id){
        super("Vehicle with id="+id+" not found");
    }
}
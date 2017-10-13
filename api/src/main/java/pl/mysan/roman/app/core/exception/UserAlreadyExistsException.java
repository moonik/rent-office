package pl.mysan.roman.app.core.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String username){
            super("User "+username+" already exists");
        }
}

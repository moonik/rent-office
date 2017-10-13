package pl.mysan.roman.app.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.mysan.roman.app.core.exception.NotFoundException;
import pl.mysan.roman.app.core.exception.UserAlreadyExistsException;

import java.text.ParseException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(Exception ex){
        return ex.getMessage();
    }

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleParseException(){
        return "Sorry, we can't parse date that You've entered :(";
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUserNotFoundException(Exception ex){
        return ex.getMessage();
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleBadCredentialsException(){
        return "User name or password is incorrect";
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(Exception ex){
        return ex.getMessage();
    }
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleException(Exception ex){
//        return "Oooops! Something went wrong :( \n\n" + ex.getMessage();
//    }
}

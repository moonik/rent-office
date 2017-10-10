package pl.mysan.roman.app.rest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.mysan.roman.app.core.exception.NotFoundException;

import java.text.ParseException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(Exception ex){
        return ex.getMessage();
    }

    @ExceptionHandler(ParseException.class)
    public String handleParseException(){
        return "Sorry, we can't parse date that You've entered :(";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "Oooops! Something went wrong :(";
    }
}

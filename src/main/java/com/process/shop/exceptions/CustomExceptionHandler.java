package com.process.shop.exceptions;

import com.process.shop.model.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class) //cuando ocurre esta excepcion dispare ese metodo
    public ResponseEntity<Response> notFoundExceptionHandle(NotFoundException notFoundException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .messages(List.of(notFoundException.getMessage()))
                        .statusCode(HttpStatus.NOT_FOUND.name())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Response> alreadyExistExceptionHandle(AlreadyExistException alreadyExistException){
        return  new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .messages(List.of(alreadyExistException.getMessage()))
                        .statusCode(HttpStatus.CONFLICT.name())
                        .build(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationException(MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String name = ((FieldError) error).getField().split("\\.")[0].split("\\[")[0];
            errors.add(
                    name.concat(" - " + error.getDefaultMessage())
            );
        });

        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .messages(errors)
                        .statusCode(HttpStatus.BAD_REQUEST.name())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Response> handleValidationExceptionNumber(MethodArgumentTypeMismatchException ex){

        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .messages(List.of("the value must be an integer"))
                        .statusCode(HttpStatus.BAD_REQUEST.name())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<Response> handleAuthenticationFailed(AuthenticationFailedException authenticationFailedException){
        return  new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .messages(List.of(authenticationFailedException.getMessage()))
                        .statusCode(HttpStatus.FORBIDDEN.name())
                        .build(),
                HttpStatus.FORBIDDEN
        );
    }
}

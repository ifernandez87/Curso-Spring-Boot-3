package es.ejemplo.manejo.excepciones.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import es.ejemplo.manejo.excepciones.exceptions.UserNotFoundException;
import es.ejemplo.manejo.excepciones.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        return ResponseEntity.internalServerError().body(Error.builder().message(ex.getMessage())
                .error("Error Matematico").status(HttpStatus.INTERNAL_SERVER_ERROR.value()).date(new Date()).build());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.builder().message(ex.getMessage())
                .error("Recurso no encontrado").status(HttpStatus.NOT_FOUND.value()).date(new Date()).build());
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatExc(Exception ex) {
        Map<String, Object> error = new HashMap<String, Object>();
        error.put("date", new Date());
        error.put("error", "Error al parsear el formato a digito");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return error;
    }

    @ExceptionHandler({ NullPointerException.class, HttpMessageNotWritableException.class,
            NoSuchElementException.class, UserNotFoundException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundExc(Exception ex) {
        Map<String, Object> error = new HashMap<String, Object>();
        error.put("date", new Date());
        error.put("error", "Usuario o rol no existe");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return error;
    }

}

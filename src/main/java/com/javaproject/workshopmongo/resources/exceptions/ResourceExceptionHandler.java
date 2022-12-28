package com.javaproject.workshopmongo.resources.exceptions;

import com.javaproject.workshopmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

   @ExceptionHandler(ObjectNotFoundException.class) //pra identificar essa exception fazer o tratamento do Metodo
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(), "Not Found ",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}

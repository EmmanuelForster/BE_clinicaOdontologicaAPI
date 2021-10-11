package edu.dh.API_clinicaOdontologica;


import edu.dh.API_clinicaOdontologica.exceptions.ResourceNotFoundException;
import org.apache.log4j.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobaExceptionHandler {


    private static final Logger log = Logger.getLogger(GlobaExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> errorProcesarBadRequest(ResourceNotFoundException ex, WebRequest req){
        log.error(ex.getMessage() + req);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}

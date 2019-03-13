package com.stackroute.gameapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerGlobalException {

    /**
     * his method handles any general Exception
     * @param e
     * @return ResponseEntity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGeneralException(Exception e){
        return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }

    /**
     * This method handles UserNotFoundException
      * @param ex
     * @return ResponseEntity
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleConflict(UserNotFoundException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
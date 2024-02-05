package com.andpostman.customer.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * Exception controller handler.
 * If an error occurs, this message will be displayed.
 */
@RestControllerAdvice
public class NotFoundAdvice {
    /**
     * Handling {@link NotFoundException NotFoundException}
     * @param exception the exception that needs to be output
     * @return message of the exception
     * @exception NotFoundException occurs when a field was not found in the table
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundHandler(NotFoundException exception){
        return exception.getMessage();
    }
}

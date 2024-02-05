package com.andpostman.order.errors;

/**
 * An exception occurs when a field was not found in the table
 * @see RuntimeException
 */
public class NotFoundException extends RuntimeException {
   public NotFoundException(){
        super("Object not found");
    }
}

package com.andpostman.customer.errors;

/**
 * An exception occurs when a field was not found in the table
 * @see RuntimeException
 */
public class NotFoundException extends RuntimeException {
   public NotFoundException(){
        super("Object not found");
    }
}

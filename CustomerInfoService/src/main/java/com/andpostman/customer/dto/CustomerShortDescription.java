package com.andpostman.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

/**
 * Describes short customer information (excluding orders)
 */
@Data
@AllArgsConstructor
public class CustomerShortDescription implements Serializable {

    /**
     * Customer's first name
     */
    private String firstName;

    /**
     * Customer's lastName
     */
    private String lastName;

    /**
     * Customer's email
     */
    private String email;

}

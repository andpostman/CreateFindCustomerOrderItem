package com.andpostman.statement.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Describes short order information (excluding orders)
 */
@Data
public class CustomerShortDescription implements Serializable {

    /**
     * Customer's first name
     */
    private String firstName;

    /**
     * Customer's last name
     */
    private String lastName;

    /**
     * Customer's email
     */
    private String email;

}

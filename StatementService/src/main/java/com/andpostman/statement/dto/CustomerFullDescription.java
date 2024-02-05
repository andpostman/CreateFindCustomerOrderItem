package com.andpostman.statement.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Describes full order information including orders
 */
@Data
public class CustomerFullDescription implements Serializable {

    /**
     * Customer's info without orders
     * @see CustomerShortDescription
     */
   private CustomerShortDescription customer;

    /**
     * Order list containing order information
     * @see OrderDto
     */
    private List<OrderDto> orderList;

    /**
     * Customer's id
     */
    private int id;

}

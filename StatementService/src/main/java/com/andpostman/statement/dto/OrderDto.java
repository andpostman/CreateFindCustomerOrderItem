package com.andpostman.statement.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Describes order information
 */
@Data
public class OrderDto implements Serializable {

    /**
     * Date of order creation
     */
    private LocalDate date;

    /**
     * List of items
     * @see ItemDto
     */
    private List<ItemDto> itemList;

    /**
     * Order's id
     */
    private int id;

    public OrderDto(int id, LocalDate date) {
        this.id = id;
        this.date = date;
        this.itemList = null;
    }
}

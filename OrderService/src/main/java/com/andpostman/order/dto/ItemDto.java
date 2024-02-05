package com.andpostman.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Describes the item information
 */
@Data
@AllArgsConstructor
public class ItemDto implements Serializable {

    /**
     * Item's id
     */
    private int id;

    /**
     * Item's name
     */
    private String name;
}

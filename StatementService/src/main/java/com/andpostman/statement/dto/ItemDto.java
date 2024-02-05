package com.andpostman.statement.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Describes item information
 */
@Data
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

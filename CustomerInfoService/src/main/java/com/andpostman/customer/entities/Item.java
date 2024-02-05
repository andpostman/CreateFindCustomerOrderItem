package com.andpostman.customer.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Describes the item database object
 */
@Entity
@Table(name = "item", schema = "marketplace",indexes = {
        @Index(name = "idx_item_id", columnList = "id")
})
@Data
public class Item {

    /**
     * Item's primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Item's name
     */
    private String name;

    /**
     * The ID of the order to which the item belongs
     * Many-to-one relationship.
     * @see Order
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}

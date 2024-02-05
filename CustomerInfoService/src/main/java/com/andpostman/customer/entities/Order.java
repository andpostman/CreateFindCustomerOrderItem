package com.andpostman.customer.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Describes the order database object
 */
@Entity
@Table(name = "order",schema = "marketplace", indexes = {
        @Index(name = "idx_order_id", columnList = "id")
})
@Data
public class Order {

    /**
     * Order's primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    /**
     * Date of order creation
     */
    LocalDate date;

    /**
     * The ID of the customer to which the order belongs
     * Many-to-one relationship.
     * @see Customer
     */
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}

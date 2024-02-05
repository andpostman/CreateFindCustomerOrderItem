package com.andpostman.order.entities;

import lombok.Data;

import javax.persistence.*;

/**
 *  Describes the customer database object
 */
@Entity
@Table(name = "customer",schema = "marketplace", indexes = {
        @Index(name = "idx_customer_email", columnList = "email")
})
@Data
public class Customer {

    /**
     *  Customer's primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     *  Customer's first name
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     *  Customer's last name
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Customer's email
     */
    private String email;
}

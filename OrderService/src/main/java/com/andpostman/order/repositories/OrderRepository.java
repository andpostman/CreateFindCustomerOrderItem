package com.andpostman.order.repositories;

import com.andpostman.order.dto.OrderDto;
import com.andpostman.order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * The database storage for interacting with the order table
 */
public interface OrderRepository extends JpaRepository <Order, Long> {

    /**
     * Searches orders by customer's email
     * @param email customer's email address for order search
     * @return {@link OrderDto} list with orders information or null
     */
    @Query("select new com.andpostman.order.dto.OrderDto(o.id,o.date)" +
            "from Order o where o.customer.email = ?1")
    Optional<List<OrderDto>> findByEmail(String email);

}

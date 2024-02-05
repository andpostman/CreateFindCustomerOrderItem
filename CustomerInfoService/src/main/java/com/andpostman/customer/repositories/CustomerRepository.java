package com.andpostman.customer.repositories;


import com.andpostman.customer.dto.CustomerShortDescription;
import com.andpostman.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;


/**
 * The database storage for interacting with the customer table
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Searches customer by email
     * @param email customer's email address for customer search
     * @return {@link CustomerShortDescription CustomerShortDescription} short information about customer (without orders)
     */
    @Query("select new com.andpostman.customer.dto.CustomerShortDescription(c.firstName,c.lastName,c.email) " +
            "from Customer c where c.email = ?1")
    Optional<CustomerShortDescription> findShortInfoByEmail(String email);

//    /**
//     * Searches all customers
//     * @return {@link List<CustomerShortDescription> CustomerShortDescription} list with short information about customers (without orders)
//     */
//    @Query("select new com.andpostman.customer.dto.CustomerShortDescription(c.firstName,c.lastName,c.email) " +
//            "from Customer c")
//    Optional<List<CustomerShortDescription>> findAllShortInfo();
}

package com.andpostman.customer.controllers;

import com.andpostman.customer.dto.CustomerShortDescription;
import com.andpostman.customer.errors.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.andpostman.customer.repositories.CustomerRepository;

import java.util.List;

/**
 * The REST controller handles http requests
 */
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    /**
     * The repository to access customers data.
     *
     * @see CustomerRepository
     */
    private final CustomerRepository customerRepository;

    /**
     * Used to search customer info by email.
     *
     * @param mail customer email which used to search data.
     * @return {@link CustomerShortDescription CustomerShortDescription} short information about customer.
     * @throws NotFoundException occurs when it doesn't find an email.
     */
    @GetMapping("/{mail}")
    CustomerShortDescription getInfo(@PathVariable String mail){
       return customerRepository.findShortInfoByEmail(mail).orElseThrow(NotFoundException::new);
    }

//    /**
//     * Used to search for all customer info.
//     *
//     * @return {@link List<CustomerShortDescription>} short information about all the customers.
//     * @throws NotFoundException occurs when it doesn't find any customers.
//     */
//    @GetMapping("/info")
//    List<CustomerShortDescription> getCustomers(){
//        return customerRepository.findAllShortInfo().orElseThrow(NotFoundException::new);
//    }

}

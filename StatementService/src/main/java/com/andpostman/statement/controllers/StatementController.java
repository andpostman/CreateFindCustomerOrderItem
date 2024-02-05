package com.andpostman.statement.controllers;

import com.andpostman.statement.dto.CustomerShortDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.andpostman.statement.dto.CustomerFullDescription;
import java.util.List;

/**
 * The REST controller handles http requests
 */
@Slf4j
@RestController
public class StatementController {

    /**
     * The URL of the service to get information about the customer
     */
    @Value("${service.customers.url}") String customerService;

    /**
     * The URL of the service for getting information about the customer's orders
     */
    @Value("${service.orders.url}") String orderService;


    /**
     * Getting information about the customer, which is searched by the customer's mail
     * @param email {@link String} customer's email
     * @return fullDescription - {@link CustomerFullDescription } full information of the client
     */
    @GetMapping("/{email}")
    CustomerFullDescription getStatementByEmail(@PathVariable("email") String email) {
        CustomerFullDescription fullDescription = new CustomerFullDescription();
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<CustomerShortDescription> customerRequest = restTemplate.getForEntity(customerService + email, CustomerShortDescription.class);
            fullDescription.setCustomer(customerRequest.getBody());
            var ordersRequest = restTemplate.getForEntity(orderService + email, List.class);
            fullDescription.setOrderList(ordersRequest.getBody());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return fullDescription;
    }

}

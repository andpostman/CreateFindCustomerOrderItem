package com.andpostman.order.controllers;

import com.andpostman.order.dto.ItemDto;
import com.andpostman.order.dto.OrderDto;
import com.andpostman.order.errors.NotFoundException;
import com.andpostman.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.andpostman.order.repositories.ItemRepository;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * The REST controller handles http requests
 */
@RestController
@RequiredArgsConstructor
public class OrderInfoController {

    /**
     * The repository to access orders data.
     *
     * @see OrderRepository
     */
    private final OrderRepository orderRepository;

    /**
     * The repository to access items data.
     *
     * @see ItemRepository
     */
    private final ItemRepository itemRepository;

    /**
     * Used to receive information about orders sought by the customer's mail
     * @param email {@link String} email of the customer
     * @return list of {@link OrderDto orders}
     * @throws NotFoundException occurs when it doesn't find an email.
     */
    @GetMapping(value = "/ordersinfo/{email}")
    List<OrderDto> getOrdersInfo(@PathVariable("email") String email){
        List<OrderDto> result = orderRepository.findByEmail(email).orElseThrow(NotFoundException::new);
        for (OrderDto temp : result) {
            List<ItemDto> orderItems = itemRepository.findItemsById(temp.getId()).orElseThrow(NotFoundException::new);
            temp.setItemList(orderItems);
        }
        return result;
    }
}

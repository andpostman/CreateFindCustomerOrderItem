package com.andpostman.order.repositories;

import com.andpostman.order.dto.ItemDto;
import com.andpostman.order.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * The database storage for interacting with the item table
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Searches items by order id
     * @param id order id
     * @return {@link ItemDto} List with items information or null
     */
    @Query("select new com.andpostman.order.dto.ItemDto(item.id, item.name) " +
            "from Item item where item.order.id = ?1")
    Optional<List<ItemDto>> findItemsById(int id);
}

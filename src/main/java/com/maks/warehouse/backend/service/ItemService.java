package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllOrderByNumberOfModifications();
    List<Item> findAllByNameIgnoreCaseContainingOrderByNumberOfModifications(String phrase);
    Item save(Item item);
}

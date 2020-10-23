package com.maks.warehouse.domain.service;

import com.maks.warehouse.domain.model.Item;

import java.util.List;

public interface ItemService extends Service<Item, Long> {
    List<Item> findAllOrderByNumberOfModifications();
    List<Item> findAllByNameIgnoreCaseContainingOrderByNumberOfModifications(String phrase);
}

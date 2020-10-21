package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.mapper.ItemMapper;
import com.maks.warehouse.backend.model.Item;
import com.maks.warehouse.backend.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final Sort SORT_BY_NUMBER_OF_MODIFICATIONS
            = Sort.by(Sort.Direction.DESC, "numberOfModifications");

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<Item> findAllOrderByNumberOfModifications() {
        return itemRepository.findAll(SORT_BY_NUMBER_OF_MODIFICATIONS)
                .stream().map(itemMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllByNameIgnoreCaseContainingOrderByNumberOfModifications(String phrase) {
        return itemRepository.findAllByNameIgnoreCaseContaining(phrase, SORT_BY_NUMBER_OF_MODIFICATIONS)
                .stream().map(itemMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Item save(Item item) {
        return itemMapper.toDomain(itemRepository.save(itemMapper.toEntity(item)));
    }
}

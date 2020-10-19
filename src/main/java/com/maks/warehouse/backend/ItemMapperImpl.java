package com.maks.warehouse.backend;

import com.maks.warehouse.backend.entities.ItemEntity;
import com.maks.warehouse.backend.entities.UnitOfMeasure;
import com.maks.warehouse.backend.model.Item;
import com.maks.warehouse.backend.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapper {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public ItemMapperImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Item toDomain(ItemEntity entity) {
        return new Item(
                entity.getId(),
                entity.getName(),
                entity.getQuantity(),
                entity.getUnitOfMeasure().getName()
        );
    }

    @Override
    public ItemEntity toEntity(Item domain) {
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository
                .findByName(domain.getUnitOfMeasure())
                .orElseThrow();

        return new ItemEntity(
                domain.getName(),
                domain.getQuantity(),
                unitOfMeasure
        );
    }
}

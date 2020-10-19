package com.maks.warehouse.backend.repositories;

import com.maks.warehouse.backend.entities.ItemEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findAllByNameIgnoreCaseContaining(String phrase, Sort sort);
}

package com.maks.warehouse.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity extends AbstractEntity {

    private String name;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "unit_of_measure_id")
    private UnitOfMeasure unitOfMeasure;

    private Integer numberOfModifications = 0;

    public ItemEntity(String name, Double quantity, UnitOfMeasure unitOfMeasure) {
        this.name = name;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
    }
}

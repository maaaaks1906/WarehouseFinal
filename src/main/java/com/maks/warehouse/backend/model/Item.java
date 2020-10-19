package com.maks.warehouse.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Long id;
    private String name;
    private Double quantity;
    private String unitOfMeasure;
}

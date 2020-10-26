package com.maks.warehouse.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ItemSearchCriteria {
    String name;
    Double quantity;
    String unitOfMeasure;
}

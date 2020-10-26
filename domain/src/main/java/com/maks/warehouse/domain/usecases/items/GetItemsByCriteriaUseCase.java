package com.maks.warehouse.domain.usecases.items;

import com.maks.warehouse.domain.ItemSearchCriteria;
import com.maks.warehouse.domain.model.Item;

import java.util.Collection;

public interface GetItemsByCriteriaUseCase {
    Collection<Item> invoke(ItemSearchCriteria itemSearchCriteria);
}

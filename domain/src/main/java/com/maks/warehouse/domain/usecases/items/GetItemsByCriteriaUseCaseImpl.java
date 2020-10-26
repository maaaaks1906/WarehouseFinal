package com.maks.warehouse.domain.usecases.items;

import com.maks.warehouse.domain.ItemSearchCriteria;
import com.maks.warehouse.domain.model.Item;
import com.maks.warehouse.domain.service.ItemService;
import lombok.AllArgsConstructor;
import java.util.Collection;

@AllArgsConstructor
public class GetItemsByCriteriaUseCaseImpl implements GetItemsByCriteriaUseCase {

    private ItemService itemService;

    @Override
    public Collection<Item> invoke(ItemSearchCriteria itemSearchCriteria) {
        return itemService.findAllByCriteria(itemSearchCriteria);
    }
}

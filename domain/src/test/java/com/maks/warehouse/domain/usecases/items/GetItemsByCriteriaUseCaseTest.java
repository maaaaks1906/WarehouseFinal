package com.maks.warehouse.domain.usecases.items;

import com.maks.warehouse.domain.ItemSearchCriteria;
import com.maks.warehouse.domain.model.Item;
import com.maks.warehouse.domain.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.*;

public class GetItemsByCriteriaUseCaseTest extends BaseTest {

    @Mock
    private ItemService itemService;

    private GetItemsByCriteriaUseCase getItemsByCriteriaUseCase;

    @Before
    public void setUp() throws Exception {
        getItemsByCriteriaUseCase = new GetItemsByCriteriaUseCaseImpl(itemService);
    }

    @Test
    public void shouldReturnItemsFilteredBySearchCriteria() {
        // Given
        ItemSearchCriteria searchCriteria = ItemSearchCriteria.builder().name("Screw").build();
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(1L, "Screw 1", 10D, "PCS"),
                new Item(2L, "Screw 2", 20D, "PCS")
        ));
        when(itemService.findAllByCriteria(searchCriteria)).thenReturn(items);

        // When
        List<Item> result = (List<Item>) getItemsByCriteriaUseCase.invoke(searchCriteria);

        // Then
        assertThat(result).isEqualTo(items);
        verify(itemService, times(1)).findAllByCriteria(searchCriteria);
        verifyNoMoreInteractions(itemService);
    }
}
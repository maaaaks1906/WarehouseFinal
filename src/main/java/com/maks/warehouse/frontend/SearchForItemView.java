package com.maks.warehouse.frontend;

import com.maks.warehouse.backend.model.Item;
import com.maks.warehouse.backend.service.ItemService;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("search_items")
public class SearchForItemView extends VerticalLayout {

    private final TextField ITEM_SEARCH_TEXTFIELD = new TextField("", this::onItemSearchChange);

    private final Button ADD_ITEM_BUTTON = new Button("New Item", this::onAddItemButtonClick);

    private final Grid<Item> SEARCH_RESULTS = new Grid<>(Item.class);

    private final ItemService ITEM_SERVICE;

    @Autowired
    public SearchForItemView(ItemService ITEM_SERVICE) {
        this.ITEM_SERVICE = ITEM_SERVICE;
        createLayout();
    }

    // TODO: 23/10/2020 Itemy na liscie nie laduja sie odrazu
    public void createLayout() {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        ITEM_SEARCH_TEXTFIELD.setPlaceholder("Search...");
        ITEM_SEARCH_TEXTFIELD.setValueChangeMode(ValueChangeMode.EAGER);

        HorizontalLayout topLayout = new HorizontalLayout(ITEM_SEARCH_TEXTFIELD, ADD_ITEM_BUTTON);
        VerticalLayout layout = new VerticalLayout(topLayout, SEARCH_RESULTS);
        layout.setWidth("50%");

        add(layout);
    }

    private void loadItems() {
        List<Item> itemEntities = ITEM_SERVICE.findAllOrderByNumberOfModifications();
        SEARCH_RESULTS.setItems(itemEntities);
    }

    private void onItemSearchChange(AbstractField.ComponentValueChangeEvent<TextField, String> e) {
        String value = e.getValue();
        if (value.isEmpty()) {
            loadItems();
        } else {
            List<Item> itemEntities = ITEM_SERVICE.findAllByNameIgnoreCaseContainingOrderByNumberOfModifications(value);
            SEARCH_RESULTS.setItems(itemEntities);
        }
    }

    private void onAddItemButtonClick(ClickEvent<Button> buttonClickEvent) {
        // TODO: 23/10/2020
    }
}

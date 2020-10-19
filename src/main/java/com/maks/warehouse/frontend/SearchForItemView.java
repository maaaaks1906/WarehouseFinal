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

@Route("search")
public class SearchForItemView extends VerticalLayout {

    private TextField itemSearch = new TextField("", this::onItemSearchChange);

    private Button addItem = new Button("New Item", this::onAddItemButtonClick);

    private Grid<Item> searchResults = new Grid<>(Item.class);
    private ItemService itemService;

    @Autowired
    public SearchForItemView(ItemService itemService) {
        this.itemService = itemService;

        createLayout();
        loadItems();
    }

    public SearchForItemView() {
    }

    public void createLayout() {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        itemSearch.setPlaceholder("Search...");
        itemSearch.setValueChangeMode(ValueChangeMode.EAGER);

        HorizontalLayout topLayout = new HorizontalLayout(itemSearch, addItem);
        VerticalLayout layout = new VerticalLayout(topLayout, searchResults);
        layout.setWidth("50%");

        add(layout);
    }

    private void loadItems() {
        List<Item> itemEntities = itemService.findAllOrderByNumberOfModifications();
        searchResults.setItems(itemEntities);
    }

    private void onItemSearchChange(AbstractField.ComponentValueChangeEvent<TextField, String> e) {
        String value = e.getValue();
        if (value.isEmpty()) {
            loadItems();
        } else {
            List<Item> itemEntities = itemService.findAllByNameIgnoreCaseContainingOrderByNumberOfModifications(value);
            searchResults.setItems(itemEntities);
        }
    }

    private void onAddItemButtonClick(ClickEvent<Button> buttonClickEvent) {

    }
}

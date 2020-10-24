package com.maks.warehouse.frontend;

import com.maks.warehouse.backend.model.Customer;
import com.maks.warehouse.backend.service.CustomerService;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route("search_customers")
public class SearchForCustomerView extends VerticalLayout {

    private final TextField SEARCH_FOR_CUSTOMER_TEXT_FIELD = new TextField(
            "",
            "Type here...",
            this::onCustomerSearchChange
    );

    private final Button ADD_BUTTON = new Button(
            "Add customer",
            new Icon(VaadinIcon.FILE_ADD),
            this::onAddButtonClick
    );

    private final Button PROCEED_BUTTON = new Button(
            "Proceed",
            new Icon(VaadinIcon.FORWARD),
            this::onProceedButtonClick
    );

    private final Grid<Customer> SEARCH_RESULTS = new Grid<>(Customer.class);

    private final CustomerService CUSTOMER_SERVICE;
    @Autowired
    public SearchForCustomerView(CustomerService customer_service) {
        CUSTOMER_SERVICE = customer_service;
        createLayout();
    }

    private void createLayout() {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        SEARCH_FOR_CUSTOMER_TEXT_FIELD.setValueChangeMode(ValueChangeMode.EAGER);

        HorizontalLayout topLayout = new HorizontalLayout(SEARCH_FOR_CUSTOMER_TEXT_FIELD, ADD_BUTTON);
        VerticalLayout centralLayout = new VerticalLayout(topLayout, SEARCH_RESULTS, PROCEED_BUTTON);
        centralLayout.setWidth("50%");

        add(centralLayout);
    }

    private void loadCustomers() {
//        List<Customer> customerEntities = CUSTOMER_SERVICE.findAll();
//        SEARCH_RESULTS.setItems(customerEntities);
    }


    private void onCustomerSearchChange(AbstractField.ComponentValueChangeEvent<TextField, String> e) {
//        String value = e.getValue();
//        if (value.isEmpty()) {
//            loadCustomers();
//        } else {
//            List<Customer> customerEntities = CUSTOMER_SERVICE.findAllOrderAlphabetically(value);
//            SEARCH_RESULTS.setItems(customerEntities);
//        }

    }

    private void onProceedButtonClick(ClickEvent<Button> buttonClickEvent) {

    }

    private void onAddButtonClick(ClickEvent<Button> buttonClickEvent) {

    }

}

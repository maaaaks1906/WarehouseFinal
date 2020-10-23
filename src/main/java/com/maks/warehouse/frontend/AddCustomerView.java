package com.maks.warehouse.frontend;

import com.maks.warehouse.backend.model.Customer;
import com.maks.warehouse.backend.service.CustomerService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("new_customer")
public class AddCustomerView extends VerticalLayout {
    private TextField firstNameTextField = new TextField("First name");
    private TextField middleNameTextField = new TextField("Middle name");
    private TextField lastNameTextField = new TextField("Last name");
    private TextField addressTextField = new TextField("Address");
    private TextField phoneNumberTextField = new TextField("Phone Number");
    private TextField emailAddressTextField = new TextField("E-mail");
    private TextField socialSecurityNumberTextField = new TextField("Social security number");

    private Button saveButton = new Button("Save", this::onSaveButtonClick);
    private Button clearButton = new Button("Clear", new Icon(VaadinIcon.ERASER), this::onClearButtonClick);
    private Button returnButton = new Button("Return", new Icon(VaadinIcon.ARROW_BACKWARD), this::onReturnButtonClick);

    private CustomerService customerService;

    @Autowired
    public AddCustomerView(CustomerService customerService) {
        this.customerService = customerService;
        createLayout();
    }

    private void createLayout() {
        setSizeFull();

        HorizontalLayout nameLayout = new HorizontalLayout(firstNameTextField, middleNameTextField, lastNameTextField);
        HorizontalLayout localizationLayout = new HorizontalLayout(addressTextField, phoneNumberTextField);
        HorizontalLayout emailAndSocialNumbLayout = new HorizontalLayout(emailAddressTextField, socialSecurityNumberTextField);

        HorizontalLayout saveAndClearButtonLayout = new HorizontalLayout(saveButton, clearButton);
        HorizontalLayout returnButtonLayout = new HorizontalLayout(returnButton);

        add(nameLayout);
        add(localizationLayout);
        add(emailAndSocialNumbLayout);
        add(saveAndClearButtonLayout);
        add(returnButtonLayout);
    }

    private void onReturnButtonClick(ClickEvent<Button> buttonClickEvent) {
        UI.getCurrent().navigate(MainMenuView.class);
    }

    private void onClearButtonClick(ClickEvent<Button> buttonClickEvent) {
        firstNameTextField.clear();
        middleNameTextField.clear();
        lastNameTextField.clear();
        addressTextField.clear();
        phoneNumberTextField.clear();
        emailAddressTextField.clear();
        socialSecurityNumberTextField.clear();
    }

    private void onSaveButtonClick(ClickEvent<Button> buttonClickEvent) {
        Customer customer = new Customer(
                firstNameTextField.getValue(),
                middleNameTextField.getValue(),
                lastNameTextField.getValue(),
                addressTextField.getValue(),
                phoneNumberTextField.getValue(),
                emailAddressTextField.getValue(),
                socialSecurityNumberTextField.getValue()
        );

        customerService.addCustomer(customer);
    }
}

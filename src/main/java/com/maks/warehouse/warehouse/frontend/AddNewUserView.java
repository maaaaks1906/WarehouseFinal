package com.maks.warehouse.warehouse.frontend;

import com.maks.warehouse.warehouse.backend.entities.User;
import com.maks.warehouse.warehouse.backend.repositories.UserRepositoryImpl;
import com.maks.warehouse.warehouse.backend.service.UserService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("add_new_user")
public class AddNewUserView extends VerticalLayout {

    private UserService userService;

    private PasswordField passwordField = new PasswordField(
            "Type password, only digits!",
            "password"
    );

    private PasswordField repeatPassword = new PasswordField(
            "Repeat password"
            , "repeat password");

    private TextField emailTextField = new TextField("", "e-mail");
    private Button submitButton = new Button("Submit", new Icon(VaadinIcon.THUMBS_UP),this::onSubmitButtonClick);

    @Autowired
    public AddNewUserView(UserService userService) {
        this.userService = userService;
        createLayout();
    }

    private void createLayout() {
        setSizeFull();

        VerticalLayout mainLayout = new VerticalLayout(passwordField, repeatPassword, emailTextField, submitButton);

        mainLayout.setHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);
    }

    private void onSubmitButtonClick(ClickEvent<Button> buttonClickEvent) {

        if (repeatPassword.getValue().equals(passwordField.getValue())) {
            // TODO: 16/10/2020 digits only + nullpointer
            User user = new User(passwordField.getValue(), emailTextField.getValue());
            userService.addUser(user);
        } else {
            Notification.show("Given passwords are not equal!");
        }
    }
}

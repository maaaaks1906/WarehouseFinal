package com.maks.warehouse.frontend;

import com.maks.warehouse.backend.model.User;
import com.maks.warehouse.backend.service.UserService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
    private Button submitButton = new Button("Submit", new Icon(VaadinIcon.THUMBS_UP), this::onSubmitButtonClick);

    @Autowired
    public AddNewUserView(UserService userService) {
        this.userService = userService;
        createLayout();
    }

    private void createLayout() {
        setSizeFull();

        HorizontalLayout passwordLayout = new HorizontalLayout(passwordField);
        HorizontalLayout repeatPasswordLayout = new HorizontalLayout(repeatPassword);
        HorizontalLayout emailLayout = new HorizontalLayout(emailTextField);
        HorizontalLayout submitButtonLayout = new HorizontalLayout(submitButton);

        passwordLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        repeatPasswordLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        emailLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        submitButtonLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        VerticalLayout mainLayout = new VerticalLayout(passwordLayout, repeatPasswordLayout,emailLayout, submitButtonLayout);
        add(mainLayout);
    }

    private void onSubmitButtonClick(ClickEvent<Button> buttonClickEvent) {

        //Dzieki wstrzyknieciu UserService do konstruktora i adnotacji @Autowired nie dostaje nullpointera

        if (repeatPassword.getValue().equals(passwordField.getValue())) {
            // TODO: 16/10/2020 digits only
            if (passwordField.getValue().matches("[0-9]+") && repeatPassword.getValue().matches("[0-9]+")) {
                User user = new User(emailTextField.getValue(), passwordField.getValue());
//                userService.save(user);
                Notification.show("User added", 2000, Notification.Position.BOTTOM_CENTER);
                LoginView loginView = new LoginView();
                removeAll();
                add(loginView);
                // TODO: 16/10/2020 To na bank nie tak ma wygladac
            } else {
                Notification.show("Password must contain only digits!");
            }
        } else {
            Notification.show("Given passwords are not equal!");
        }
    }
}

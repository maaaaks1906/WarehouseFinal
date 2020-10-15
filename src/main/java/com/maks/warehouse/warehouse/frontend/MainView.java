package com.maks.warehouse.warehouse.frontend;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/*
Chcialbym zeby ten layout wygladal tak:
jakies fajne zdjecie w tle
i moze na poczatek tylko login i haslo, ale docelowo
chcialbym zeby byl tylko textfield i duze przyciski,
a logowanie zeby odbywalo sie poprzez krotki kod.
 */

@Route("")
public class MainView extends VerticalLayout {

    private TextField username = new TextField("", "username");
    private PasswordField password = new PasswordField("", "password");
    private Button loginButton = new Button("Sign In", new Icon(VaadinIcon.SIGN_IN));
    private Button resetButton = new Button("Reset", new Icon(VaadinIcon.REFRESH),this::onResetButtonClick);

    @Autowired
    public MainView() {
        createLayout();
    }

    public void createLayout() {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        HorizontalLayout usernameLayout = new HorizontalLayout(username);
        HorizontalLayout passwordLayout = new HorizontalLayout(password);
        HorizontalLayout buttonsLayout = new HorizontalLayout(loginButton, resetButton);

        VerticalLayout layout = new VerticalLayout(
                usernameLayout,
                passwordLayout,
                buttonsLayout
        );

        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.setWidth("50%");

        add(layout);
    }

    private void onResetButtonClick(ClickEvent<Button> buttonClickEvent) {
        username.clear();
        password.clear();
    }

}



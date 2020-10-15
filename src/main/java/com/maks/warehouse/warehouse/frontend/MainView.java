package com.maks.warehouse.warehouse.frontend;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

/*
Chcialbym zeby ten layout wygladal tak:
jakies fajne zdjecie w tle
i moze na poczatek tylko login i haslo, ale docelowo
chcialbym zeby byl tylko textfield i duze przyciski,
a logowanie zeby odbywalo sie poprzez krotki kod.
 */

public class MainView extends VerticalLayout {

    private TextField username = new TextField("", "username");
    private PasswordField password = new PasswordField("", "password");
    private Button loginButton = new Button("Sign In");

}

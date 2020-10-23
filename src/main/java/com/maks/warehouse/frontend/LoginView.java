package com.maks.warehouse.frontend;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("")
public class LoginView extends VerticalLayout {

    private PasswordField password = new PasswordField("", "password");

    private Button oneButton = new Button("1", this::onOneButtonClick);
    private Button twoButton = new Button("2", this::onTwoButtonClick);
    private Button threeButton = new Button("3", this::onThreeButtonClick);
    private Button fourButton = new Button("4", this::onFourButtonClick);
    private Button fiveButton = new Button("5", this::onFiveButtonClick);
    private Button sixButton = new Button("6", this::onSixButtonClick);
    private Button sevenButton = new Button("7", this::onSevenButtonClick);
    private Button eightButton = new Button("8", this::onEightButtonClick);
    private Button nineButton = new Button("9", this::onNineButtonClick);
    private Button zeroButton = new Button("0", this::onZeroButtonClick);

    private Button loginButton = new Button("Login", new Icon(VaadinIcon.SIGN_IN_ALT),this::onLoginButtonClick);
    private Button resetButton = new Button("Reset", new Icon(VaadinIcon.REFRESH),this::onResetButtonClick);

    @Autowired
    public LoginView() {
        createLayout();
    }

    public void createLayout() {
        setSizeFull();

        HorizontalLayout passwordLayout = new HorizontalLayout(password);

        HorizontalLayout oneTwoThreeLayout = new HorizontalLayout(oneButton, twoButton, threeButton);
        HorizontalLayout fourFiveSixLayout = new HorizontalLayout(fourButton, fiveButton, sixButton);
        HorizontalLayout sevenEightNineLayout = new HorizontalLayout(sevenButton, eightButton, nineButton);
        HorizontalLayout zeroLayout = new HorizontalLayout(zeroButton);
        HorizontalLayout buttonLayout = new HorizontalLayout(loginButton,resetButton);

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(
                passwordLayout,
                oneTwoThreeLayout,
                fourFiveSixLayout,
                sevenEightNineLayout,
                zeroLayout,
                buttonLayout
        );

    }

    private void onLoginButtonClick(ClickEvent<Button> buttonClickEvent) {
        UI.getCurrent().navigate(SearchForItemView.class);
    }

    private void onResetButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.clear();
    }

    private void onOneButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 1);
    }

    private void onTwoButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 2);
    }

    private void onThreeButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 3);
    }

    private void onFourButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 4);
    }

    private void onFiveButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 5);
    }

    private void onSixButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 6);
    }

    private void onSevenButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 7);
    }

    private void onEightButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 8);
    }

    private void onNineButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 9);
    }

    private void onZeroButtonClick(ClickEvent<Button> buttonClickEvent) {
        password.setValue(password.getValue() + 0);
    }

}



package com.maks.warehouse.warehouse;

import com.maks.warehouse.warehouse.backend.entities.User;
import com.maks.warehouse.warehouse.backend.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class CreateUserDatabase {
    private UserService userService;

    public CreateUserDatabase(UserService userService) {
        this.userService = userService;
    }

    @Value("$(username)")
    private String username;

    @Value("$(email)")
    private String email;

    @EventListener(ApplicationReadyEvent.class)
    public void addUser() {
        User user = new User(username, email);
        userService.addUser(user);
    }
}

package com.maks.warehouse;

import com.maks.warehouse.backend.entities.UserEntity;
import com.maks.warehouse.backend.service.UserService;
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
        UserEntity userEntity = new UserEntity(username, email);
        userService.save(userEntity);
    }
}

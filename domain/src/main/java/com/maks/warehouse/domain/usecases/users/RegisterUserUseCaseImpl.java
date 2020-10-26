package com.maks.warehouse.domain.usecases.users;

import com.maks.warehouse.domain.model.User;
import com.maks.warehouse.domain.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final UserService userService;

    @Override
    public User invoke(User user) {
        // TODO: 26/10/2020 validation of username, email etc.
        return userService.save(user);
    }
}

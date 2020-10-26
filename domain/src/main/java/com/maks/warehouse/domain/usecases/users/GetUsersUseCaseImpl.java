package com.maks.warehouse.domain.usecases.users;

import com.maks.warehouse.domain.model.User;
import com.maks.warehouse.domain.service.UserService;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {

    private UserService userService;

    @Override
    public Collection<User> invoke() {
        return userService.findAll();
    }
}

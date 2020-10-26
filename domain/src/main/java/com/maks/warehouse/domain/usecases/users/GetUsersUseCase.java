package com.maks.warehouse.domain.usecases.users;

import com.maks.warehouse.domain.model.User;

import java.util.Collection;

public interface GetUsersUseCase {
    Collection<User> invoke();
}

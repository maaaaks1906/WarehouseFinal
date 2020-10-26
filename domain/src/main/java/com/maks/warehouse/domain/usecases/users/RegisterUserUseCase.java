package com.maks.warehouse.domain.usecases.users;

import com.maks.warehouse.domain.model.User;

public interface RegisterUserUseCase {
    User invoke(User user);
}

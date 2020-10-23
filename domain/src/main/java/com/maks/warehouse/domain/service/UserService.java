package com.maks.warehouse.domain.service;

import com.maks.warehouse.domain.model.User;

public interface UserService extends Service<User, Long> {
    User findByPassword(String password);
}

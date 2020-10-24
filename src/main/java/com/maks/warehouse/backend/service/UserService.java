package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.model.User;

import java.util.List;


public interface UserService extends Service<User, Long> {
    User findByPassword(String password);
}

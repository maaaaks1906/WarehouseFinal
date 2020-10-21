package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.entities.UserEntity;
import com.maks.warehouse.backend.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService extends Service<User, Long> {
    User findByPassword(String password);
}

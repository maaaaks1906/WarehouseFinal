package com.maks.warehouse.warehouse.backend.service;

import com.maks.warehouse.warehouse.backend.entities.User;
import com.maks.warehouse.warehouse.backend.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepositoryImpl userRepositoryImpl;

    @Autowired
    public UserService(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public List<User> findAll() {
        return userRepositoryImpl.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepositoryImpl.findAll().stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();
    }

    public User addUser(User user) {
        return userRepositoryImpl.save(user);
    }
}

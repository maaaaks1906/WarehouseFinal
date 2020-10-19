package com.maks.warehouse.warehouse.backend.service;

import com.maks.warehouse.warehouse.backend.entities.User;
import com.maks.warehouse.warehouse.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByPassword(String password) {
        return userRepository.findAll().stream()
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}

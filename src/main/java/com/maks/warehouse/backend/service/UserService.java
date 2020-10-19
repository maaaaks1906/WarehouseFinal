package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.entities.UserEntity;
import com.maks.warehouse.backend.repositories.UserRepository;
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

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findByPassword(String password) {
        return userRepository.findAll().stream()
                .filter(userEntity -> userEntity.getPassword().equals(password))
                .findFirst();
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}

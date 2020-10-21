package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.mapper.UserMapper;
import com.maks.warehouse.backend.model.User;
import com.maks.warehouse.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User update(User user, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public User findByPassword(String password) {
        return userRepository.findByPassword(password)
                .map(userMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public User save(User user) {
        return userMapper.toDomain(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).map(userMapper::toDomain).orElseThrow();
    }

}

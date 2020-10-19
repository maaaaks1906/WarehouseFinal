package com.maks.warehouse.backend;

import com.maks.warehouse.backend.entities.UserEntity;
import com.maks.warehouse.backend.model.User;

public class UserMapperImpl implements UserMapper{
    @Override
    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword()
        );
    }

    @Override
    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getEmail(),
                user.getPassword()
        );
    }
}

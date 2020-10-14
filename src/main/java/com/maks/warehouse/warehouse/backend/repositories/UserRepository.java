package com.maks.warehouse.warehouse.backend.repositories;

import com.maks.warehouse.warehouse.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findByName(String name);

    User findByUsername(String username);

    User addUser(User user);
}

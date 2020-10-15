package com.maks.warehouse.warehouse.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Table;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

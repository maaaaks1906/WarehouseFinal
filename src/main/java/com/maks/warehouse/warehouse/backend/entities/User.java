package com.maks.warehouse.warehouse.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Table;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    private String password;
    private String email;

    public String getPassword() {
        return password;
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }
}

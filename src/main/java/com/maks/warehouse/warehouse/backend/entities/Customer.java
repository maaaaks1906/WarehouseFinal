package com.maks.warehouse.warehouse.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private String socialSecurityNumber;


    public String getFirstName() {
        return firstName;
    }
}

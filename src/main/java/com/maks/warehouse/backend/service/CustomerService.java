package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.entities.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> findAll();
    CustomerEntity findByFirstName(String firstName);
    CustomerEntity findByLastName(String lastName);
    CustomerEntity findByMiddleName(String middleName);
    CustomerEntity findBySocialNumber(String socialNumber);
    CustomerEntity addCustomer(CustomerEntity customerEntity);
}

package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);
    Customer findByMiddleName(String middleName);
    Customer findBySocialNumber(String socialNumber);
    Customer addCustomer(Customer customer);
}

package com.maks.warehouse.domain.service;

import com.maks.warehouse.domain.model.Customer;

public interface CustomerService extends Service<Customer, Long> {
    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);
    Customer findByMiddleName(String middleName);
    Customer findBySocialNumber(String socialNumber);
}

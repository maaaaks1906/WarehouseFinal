package com.maks.warehouse.warehouse.backend.service;

import com.maks.warehouse.warehouse.backend.entities.Customer;
import com.maks.warehouse.warehouse.backend.repositories.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepositoryImpl customerRepositoryImpl;

    @Autowired
    public CustomerService(CustomerRepositoryImpl customerRepositoryImpl) {
        this.customerRepositoryImpl = customerRepositoryImpl;
    }

    public List<Customer> findAll() {
        return customerRepositoryImpl.findAll();
    }

    public Optional<Customer> findByFirstName(String firstName) {
        return customerRepositoryImpl.findAll().stream()
                .filter(customer -> customer.getFirstName().equals(firstName)).findFirst();
    }

    public Customer findByLastName(String lastName) {
        return customerRepositoryImpl.findByLastName(lastName);
    }

    public Customer findByMiddleName(String middleName) {
        return customerRepositoryImpl.findByLastName(middleName);
    }

    public Customer findBySocialNumber(String socialNumber) {
        return customerRepositoryImpl.findBySocialSecurityNumber(socialNumber);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepositoryImpl.save(customer);
    }


}

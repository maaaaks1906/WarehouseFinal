package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.entities.CustomerEntity;
import com.maks.warehouse.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    public CustomerEntity findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName)
                .orElseThrow();
    }

    public CustomerEntity findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName)
                .orElseThrow();
    }

    public CustomerEntity findByMiddleName(String middleName) {
        return customerRepository.findByLastName(middleName)
                .orElseThrow();
    }

    public CustomerEntity findBySocialNumber(String socialNumber) {
        return customerRepository.findBySocialSecurityNumber(socialNumber)
                .orElseThrow();
    }

    public CustomerEntity addCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }
}

package com.maks.warehouse.warehouse.backend.service;

import com.maks.warehouse.warehouse.backend.entities.Customer;
import com.maks.warehouse.warehouse.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findByFirstName(String firstName) {
        return customerRepository.findAll().stream()
                .filter(customer -> customer.getFirstName().equals(firstName)).findFirst();
    }

    public Customer findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName)
                .orElseThrow();
    }

    public Customer findByMiddleName(String middleName) {
        return customerRepository.findByLastName(middleName)
                .orElseThrow();
    }

    public Customer findBySocialNumber(String socialNumber) {
        return customerRepository.findBySocialSecurityNumber(socialNumber)
                .orElseThrow();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}

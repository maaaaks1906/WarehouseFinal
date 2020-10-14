package com.maks.warehouse.warehouse.backend.service;

import com.maks.warehouse.warehouse.backend.entities.Customer;
import com.maks.warehouse.warehouse.backend.repositories.CustomerRepository;
import com.maks.warehouse.warehouse.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public Customer findByMiddleName(String middleName) {
        return customerRepository.findByLastName(middleName);
    }

    public Customer findBySocialNumber(String socialNumber) {
        return customerRepository.findBySocialSecurityNumber(socialNumber);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}

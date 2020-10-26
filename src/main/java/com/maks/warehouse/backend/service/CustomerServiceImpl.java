package com.maks.warehouse.backend.service;

import com.maks.warehouse.backend.mapper.CustomerMapper;
import com.maks.warehouse.backend.model.Customer;
import com.maks.warehouse.backend.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
//    private final Sort SORT = Sort.by(Sort.Direction.ASC);

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDomain)
                .collect(Collectors.toList());
    }

    public List<Customer> findAllByCredentials(String credential) {
        return null;
        // TODO: 25/10/2020
    }

    public Customer findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName)
                .map(customerMapper::toDomain)
                .orElseThrow();
    }

    public Customer findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName)
                .map(customerMapper::toDomain)
                .orElseThrow();
    }

    public Customer findByMiddleName(String middleName) {
        return customerRepository.findByLastName(middleName)
                .map(customerMapper::toDomain)
                .orElseThrow();
    }

    public Customer findBySocialNumber(String socialNumber) {
        return customerRepository.findBySocialSecurityNumber(socialNumber)
                .map(customerMapper::toDomain)
                .orElseThrow();
    }

    public Customer addCustomer(Customer customer) {
        return customerMapper.toDomain(customerRepository.save(customerMapper.toEntity(customer)));
    }
}

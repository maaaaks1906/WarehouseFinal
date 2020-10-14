package com.maks.warehouse.warehouse.backend.repositories;

import com.maks.warehouse.warehouse.backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findByName(String name);

    Customer findByLastName(String lastName);

    Customer findByMiddleName(String middleName);

    Customer findBySocialSecurityNumber(String socialSecurityNumber);

    Customer addCustomer(Customer customer);
}

package com.maks.warehouse.warehouse.backend.repositories;

import com.maks.warehouse.warehouse.backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByLastName(String lastName);

    Optional<Customer> findByMiddleName(String middleName);

    Optional<Customer> findBySocialSecurityNumber(String socialSecurityNumber);

}

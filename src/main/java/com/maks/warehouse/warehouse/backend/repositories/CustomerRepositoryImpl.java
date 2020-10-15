package com.maks.warehouse.warehouse.backend.repositories;

import com.maks.warehouse.warehouse.backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositoryImpl extends JpaRepository<Customer, Long> {

    Customer findByLastName(String lastName);

    Customer findByMiddleName(String middleName);

    Customer findBySocialSecurityNumber(String socialSecurityNumber);

}

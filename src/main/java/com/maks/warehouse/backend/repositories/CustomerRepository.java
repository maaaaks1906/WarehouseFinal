package com.maks.warehouse.backend.repositories;

import com.maks.warehouse.backend.entities.CustomerEntity;
import com.maks.warehouse.backend.model.Customer;
import com.maks.warehouse.backend.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByFirstName(String firstName);

    Optional<CustomerEntity> findByLastName(String lastName);

    Optional<CustomerEntity> findByMiddleName(String middleName);

    Optional<CustomerEntity> findBySocialSecurityNumber(String socialSecurityNumber);


}

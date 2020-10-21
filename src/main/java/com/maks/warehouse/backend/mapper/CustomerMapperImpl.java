package com.maks.warehouse.backend.mapper;

import com.maks.warehouse.backend.entities.CustomerEntity;
import com.maks.warehouse.backend.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toDomain(CustomerEntity customerEntity) {
        return new Customer(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getMiddleName(),
                customerEntity.getLastName(),
                customerEntity.getAddress(),
                customerEntity.getPhoneNumber(),
                customerEntity.getEmailAddress(),
                customerEntity.getSocialSecurityNumber()
        );
    }

    @Override
    public CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(
                customer.getFirstName(),
                customer.getMiddleName(),
                customer.getLastName(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getEmailAddress(),
                customer.getSocialSecurityNumber()
        );
    }
}

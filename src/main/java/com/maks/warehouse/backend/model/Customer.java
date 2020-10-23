package com.maks.warehouse.backend.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String middleName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String emailAddress;
    @NonNull
    private String socialSecurityNumber;
}

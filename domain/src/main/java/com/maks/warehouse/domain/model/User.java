package com.maks.warehouse.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long id;
    @NonNull private String email;
    @NonNull private String password;
}

package com.maks.warehouse.backend.service;

public interface Mapper<DOMAIN, ENTITY> {
    DOMAIN toDomain(ENTITY entity);
    ENTITY toEntity(DOMAIN domain);
}

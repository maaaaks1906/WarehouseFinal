package com.maks.warehouse.backend.service;

import java.util.List;
import java.util.Optional;

public interface Service<D, ID> {
    D save(D d);                    // C REATE
    D findById(ID id);              // R EAD
    List<D> findAll();
    D update(D d, ID id);           // U PDATE
    void deleteById(ID id);         // D ELETE
}

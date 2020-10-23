package com.maks.warehouse.domain.service;

import java.util.List;

public interface Service<D, ID> {
    D save(D d);
    D findById(ID id);
    List<D> findAll();
    D update(D d, ID id);
    void deleteById(ID id);
}

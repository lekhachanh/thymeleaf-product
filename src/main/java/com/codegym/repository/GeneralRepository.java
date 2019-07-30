package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;


public interface GeneralRepository <T> {
    List<T> findAll();
    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}

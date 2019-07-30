package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements GeneralRepository {
    private static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Sam sung J5 Prime", 200, "white-platinum"));
        productList.put(2, new Product(2, "Sam sung J7 Prime", 300, "white-platinum"));
        productList.put(3, new Product(3, "Sam sung A5 ", 400, "Black"));
        productList.put(4, new Product(4, "Sam sung A7 ", 450, "pink"));
        productList.put(5, new Product(5, "IPHONE 6S Plus ", 600, "platinum"));
        productList.put(6, new Product(6, "IPHONE XS Max ", 2000, "platinum"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}

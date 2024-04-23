package com.btn.services;

import com.btn.pojo.Product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getProducts(Map<String, String> params);
    void createProduct(String name, String description, Long price, int cateId);
    void updateProduct(int prodId, Map<String, String> params);
    void deleteProduct(int prodId);

    void addOrUpdate(Product p);
}

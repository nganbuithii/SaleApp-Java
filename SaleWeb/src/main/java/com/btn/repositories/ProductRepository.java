package com.btn.repositories;

import com.btn.pojo.Product;
import com.btn.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    List<Product> getProducts(Map<String, String> params);
    void createProduct(String name, String description, Long price, int cateId);
    void updateProduct(int prodId, Map<String, String> params);
    void deleteProduct(int prodId);
    void addOrUpdate(Product p);
    Product getProductById(int id);
}
package com.btn.services.impl;

import com.btn.pojo.Product;
import com.btn.repositories.ProductRepository;
import com.btn.repositories.impl.ProductRepositoryImpl;
import com.btn.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.productRepo.getProducts(params);
    }

    @Override
    public void createProduct(String name, String description, Long price, int cateId) {
        this.productRepo.createProduct(name, description, price, cateId);
    }

    @Override
    public void updateProduct(int prodId, Map<String, String> params) {
        this.updateProduct(prodId, params);
    }

    @Override
    public void deleteProduct(int prodId) {
        productRepo.deleteProduct(prodId);
    }
}

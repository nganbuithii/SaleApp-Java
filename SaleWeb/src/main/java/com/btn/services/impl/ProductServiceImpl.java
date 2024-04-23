package com.btn.services.impl;

import com.btn.pojo.Product;
import com.btn.repositories.ProductRepository;
import com.btn.repositories.impl.ProductRepositoryImpl;
import com.btn.services.ProductService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.productRepo.getProducts(params);
    }

    @Override
    public void createProduct(String name, String description, Long price, int cateId) {
        this.productRepo.createProduct(name, description, price, cateId);
    }
    public File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }
    @Override
    public void updateProduct(int prodId, Map<String, String> params) {
        this.productRepo.updateProduct(prodId, params);
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepo.deleteProduct(id);
    }

    @Override
    public void addOrUpdate(Product p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.productRepo.addOrUpdate(p);
    }

    @Override
    public Product getProductById(int id){
        try {
            return  this.productRepo.getProductById(id);
            // Code to get product by ID
        } catch (Exception e) {
            System.out.println("Error occurred while getting product by ID: " + e.getMessage());
        }
        return null;

    }
}

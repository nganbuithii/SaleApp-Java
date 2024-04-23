package com.btn.controllers;

import com.btn.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIProductController {
    @Autowired
    private ProductService productService;

    //    xoa san pham
    @DeleteMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "productId") int id) {
        this.productService.deleteProduct(id);
    }
}

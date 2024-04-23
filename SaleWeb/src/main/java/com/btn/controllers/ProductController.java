/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btn.controllers;

import com.btn.pojo.Product;
import com.btn.services.CategoryService;
import com.btn.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

/**
 *
 * @author admin
 */
@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
     @GetMapping("/products")
    public String createView(Model model) {
        model.addAttribute("product", new Product());
         model.addAttribute("categories", categoryService.getCates());
        return "products";
    }

    // create product
    // gui package bean
    @PostMapping("/products")
    public String createProduct(@ModelAttribute(value = "product") @Valid Product p, BindingResult rs) {
        // neu khong co loi
        if (!rs.hasErrors()) {
                try {
                    this.productService.addOrUpdate(p);
                    return "redirect:/";
                }catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
        }
        // neu co loi hien tren trang product
        return "products";
    }

    @GetMapping("/products/{productId}")
    public  String updateView(Model model, @PathVariable(value = "productId") int id)
    {
        model.addAttribute("product",this.productService.getProductById(id));

        // do thong tin ra
        return "products";
    }
}

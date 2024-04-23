/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btn.controllers;

import com.btn.pojo.Product;
import com.btn.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 * @author admin
 */
@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;
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
            return "";
        }
        // neu co loi hien tren trang product
        return "products";
    }

}

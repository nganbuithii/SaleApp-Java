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
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("products", new Product());
         model.addAttribute("categories", categoryService.getCates());
        return "products";
    }
}

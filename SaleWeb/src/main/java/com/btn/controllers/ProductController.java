/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btn.controllers;

import com.btn.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author admin
 */
@Controller
public class ProductController {


     @GetMapping("/products")
    public String createView(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }
}

package com.btn.controllers;

import com.btn.pojo.Category;
import com.btn.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiCategoryController {
    @Autowired
    private CategoryService categoryService;

//    .../api/categories/
    @GetMapping("/categories/")
    @CrossOrigin
    public ResponseEntity<List<Category>> list(){
        return new ResponseEntity<>(this.categoryService.getCates(), HttpStatus.OK);
    }

}

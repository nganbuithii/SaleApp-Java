package com.btn.controllers;

import com.btn.pojo.Category;
import com.btn.pojo.Product;
import com.btn.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIProductController {
    @Autowired
    private ProductService productService;

    //    xoa san pham
    @DeleteMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "productId") int id) {
        this.productService.deleteProduct(id);
    }

    @GetMapping("/products/")
    @CrossOrigin
//    Để cho người dùng tìm kiếm luôn, thì truyền param vào
    public ResponseEntity<List<Product>> list(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.productService.getProducts(params), HttpStatus.OK);
    }


    // xem chi tiet san pham ben
    @GetMapping(value = "/products/{productId}/" , produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Product> retrieve (@PathVariable(value="productId") int id){
        return new ResponseEntity<>(this.productService.getProductById(id),HttpStatus.OK);
    }
}

package com.enum3rat3.springesd.controller;

import com.enum3rat3.springesd.dto.ProductRequest;
import com.enum3rat3.springesd.entity.Product;
import com.enum3rat3.springesd.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProduct(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProduct(name));
    }

    @PutMapping()
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteProduct(@PathVariable String name) {
        return ResponseEntity.ok(productService.deleteProduct(name));
    }
}
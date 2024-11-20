package com.enum3rat3.springesd.service;

import com.enum3rat3.springesd.dto.ProductRequest;
import com.enum3rat3.springesd.entity.Product;
import com.enum3rat3.springesd.helper.JWTHelper;
import com.enum3rat3.springesd.mapper.ProductMapper;
import com.enum3rat3.springesd.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final JWTHelper jwtHelper;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public String addProduct(ProductRequest product) {
        Product product1 = productMapper.toProduct(product);
        productRepo.save(product1);
        return "Product added";
    }

    public Product getProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        return product;
    }

    public String updateProduct(ProductRequest product) {
        Product productt = getProduct(product.name());
        productt.setPrice(product.price());
        productRepo.save(productt);
        return "Product updated";
    }

    public String deleteProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        productRepo.delete(product);
        return "Product deleted";
    }

}
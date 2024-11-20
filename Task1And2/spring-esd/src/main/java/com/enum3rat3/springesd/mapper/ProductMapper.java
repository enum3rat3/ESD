package com.enum3rat3.springesd.mapper;

import com.enum3rat3.springesd.dto.ProductRequest;
import com.enum3rat3.springesd.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct (ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }
}
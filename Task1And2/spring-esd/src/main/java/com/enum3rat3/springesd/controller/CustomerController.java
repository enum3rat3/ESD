package com.enum3rat3.springesd.controller;

import com.enum3rat3.springesd.dto.CustomerRequest;
import com.enum3rat3.springesd.dto.CustomerResponse;
import com.enum3rat3.springesd.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{email}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("email") String email) {
        return ResponseEntity.ok(customerService.retrieveCustomer(email));
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/products")
    public ResponseEntity<String> getProducts(){
        return ResponseEntity.ok(customerService.getProductsWithPriceRange());
    }
}
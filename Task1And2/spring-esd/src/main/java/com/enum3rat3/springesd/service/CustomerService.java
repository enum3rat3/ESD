package com.enum3rat3.springesd.service;

import com.enum3rat3.springesd.dto.CustomerRequest;
import com.enum3rat3.springesd.dto.CustomerResponse;
import com.enum3rat3.springesd.dto.LoginRequest;
import com.enum3rat3.springesd.entity.Customer;
import com.enum3rat3.springesd.entity.Product;
import com.enum3rat3.springesd.exception.CustomerNotFoundException;
import com.enum3rat3.springesd.helper.EncryptionService;
import com.enum3rat3.springesd.helper.JWTHelper;
import com.enum3rat3.springesd.mapper.CustomerMapper;
import com.enum3rat3.springesd.repo.CustomerRepo;
import com.enum3rat3.springesd.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }

    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }

        return jwtHelper.generateToken(request.email());
    }

    @Autowired
    private ProductRepo productRepo;

    public String getProductsWithPriceRange() {
        List<Product> products = productRepo.findTop2ByPriceBetweenOrderByPriceAsc();
        StringBuilder pro = new StringBuilder();
        for(Product product : products) {
            pro.append(product.getName()).append(",");
        }
        return pro.toString();
    }
}
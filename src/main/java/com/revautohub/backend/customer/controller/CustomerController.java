package com.revautohub.backend.customer.controller;

import com.revautohub.backend.customer.dto.CustomerLoginRequest;
import com.revautohub.backend.customer.dto.CustomerRegisterRequest;
import com.revautohub.backend.customer.dto.CustomerResponse;
import com.revautohub.backend.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> registerCustomer(
            @RequestBody CustomerRegisterRequest request
            ){
        CustomerResponse response = customerService.registerCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<CustomerResponse> loginCustomer(
            @RequestBody CustomerLoginRequest request
    ){
        CustomerResponse response = customerService.loginCustomer(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(
            @PathVariable Long id
    ){
        CustomerResponse response = customerService.getCustomerById(id);
        return ResponseEntity.ok(response);
    }



}

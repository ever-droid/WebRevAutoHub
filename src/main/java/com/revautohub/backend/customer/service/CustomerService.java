package com.revautohub.backend.customer.service;

import com.revautohub.backend.customer.dto.CustomerLoginRequest;
import com.revautohub.backend.customer.dto.CustomerRegisterRequest;
import com.revautohub.backend.customer.dto.CustomerResponse;
import com.revautohub.backend.customer.repository.CustomerRepository;
import com.revautohub.backend.user.Role;
import com.revautohub.backend.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder passwordEncoder){
        this.customerRepository =customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerResponse registerCustomer(CustomerRegisterRequest request){
        if (customerRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException("Email is already registered.");
        }

        if(customerRepository.existsByPhoneNumber(request.phoneNumber())){
            throw new IllegalArgumentException("Phone number is already registered.");
        }

        String hashedPassword = passwordEncoder.encode(request.password());

        User customer = new User(
                request.fullName(),
                request.email(),
                request.phoneNumber(),
                hashedPassword,
                Role.CUSTOMER
        );

        User savedCustomer = customerRepository.save(customer);

        return mapToCustomerResponse(savedCustomer);


    }
    public CustomerResponse loginCustomer(CustomerLoginRequest request) {

        User customer = customerRepository.findByEmail(request.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        if (customer.getRole() != Role.CUSTOMER) {
            throw new IllegalArgumentException("This account is not a customer account.");
        }

        boolean passwordMatches = passwordEncoder.matches(
                request.password(),
                customer.getPassword()
        );

        if (!passwordMatches) {
            throw new IllegalArgumentException("Invalid email or password.");
        }

        return mapToCustomerResponse(customer);
    }


    public CustomerResponse getCustomerById(Long id){

        User customer = customerRepository.findByIdAndRole(id, Role.CUSTOMER)
                .orElseThrow( () -> new IllegalArgumentException("Customer not found."));

        return mapToCustomerResponse(customer);

    }

    private CustomerResponse mapToCustomerResponse(User user){
        return new CustomerResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole().name()
        );
    }



}

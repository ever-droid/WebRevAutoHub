package com.revautohub.backend.customer.dto;

public  record CustomerResponse(
        Long id,
        String fullName,
        String email,
        String phoneNumber,
        String role
){

}

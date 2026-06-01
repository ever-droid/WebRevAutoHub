package com.revautohub.backend.customer.dto;

public record CustomerRegisterRequest(
        String fullName,
        String email,
        String phoneNumber,
        String password
) {

}


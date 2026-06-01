package com.revautohub.backend.payment.service.impl;

import com.revautohub.backend.config.DarajaConfig;
import com.revautohub.backend.payment.dto.DarajaTokenResponseDTO;
import com.revautohub.backend.payment.dto.PaymentRequestDTO;
import com.revautohub.backend.payment.dto.PaymentResponseDTO;
import com.revautohub.backend.payment.dto.StkPushResponseDTO;
import com.revautohub.backend.payment.service.PaymentService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PaymentServiceImpl implements PaymentService {

    // Daraja configuration values
    private final DarajaConfig darajaConfig;

    // Constructor injection
    public PaymentServiceImpl(DarajaConfig darajaConfig) {
        this.darajaConfig = darajaConfig;
    }

    // Receive payment details from frontend,
    // send STK Push request to Daraja,
    // and return Daraja response
    @Override
    public StkPushResponseDTO stkPush(
            PaymentRequestDTO paymentRequestDTO) {

        // Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Generate OAuth credentials
        String credentials =
                darajaConfig.getConsumerKey() + ":" +
                        darajaConfig.getConsumerSecret();

        // Encode credentials to Base64
        String encodedCredentials = Base64.getEncoder()
                .encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

        // Create headers for OAuth request
        HttpHeaders tokenHeaders = new HttpHeaders();
        tokenHeaders.set("Authorization", "Basic " + encodedCredentials);

        HttpEntity<String> tokenRequest =
                new HttpEntity<>(tokenHeaders);

        // Request access token from Daraja
        ResponseEntity<DarajaTokenResponseDTO> tokenResponse =
                restTemplate.exchange(
                        darajaConfig.getOauthUrl(),
                        HttpMethod.GET,
                        tokenRequest,
                        DarajaTokenResponseDTO.class
                );

        // Extract access token
        String accessToken =
                tokenResponse.getBody().getAccess_token();

        // Generate timestamp
        String timestamp = new SimpleDateFormat(
                "yyyyMMddHHmmss").format(new Date());

        // Generate password
        String passwordString =
                darajaConfig.getShortCode() +
                        darajaConfig.getPassKey() +
                        timestamp;

        String password = Base64.getEncoder()
                .encodeToString(
                        passwordString.getBytes(StandardCharsets.UTF_8));

        // Create STK Push request body
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("BusinessShortCode",
                darajaConfig.getShortCode());

        requestBody.put("Password", password);

        requestBody.put("Timestamp", timestamp);

        requestBody.put("TransactionType",
                "CustomerPayBillOnline");

        requestBody.put("Amount",
                paymentRequestDTO.getAmount());

        requestBody.put("PartyA",
                paymentRequestDTO.getPhoneNumber());

        requestBody.put("PartyB",
                darajaConfig.getShortCode());

        requestBody.put("PhoneNumber",
                paymentRequestDTO.getPhoneNumber());

        requestBody.put("CallBackURL",
                darajaConfig.getCallbackUrl());

        requestBody.put("AccountReference",
                darajaConfig.getAccountReference());

        requestBody.put("TransactionDesc",
                darajaConfig.getTransactionDesc());

        // Create STK Push headers
        HttpHeaders stkHeaders = new HttpHeaders();

        stkHeaders.setBearerAuth(accessToken);

        stkHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> stkRequest =
                new HttpEntity<>(requestBody, stkHeaders);

        // Send STK Push request
        ResponseEntity<StkPushResponseDTO> stkResponse =
                restTemplate.exchange(
                        darajaConfig.getStkPushUrl(),
                        HttpMethod.POST,
                        stkRequest,
                        StkPushResponseDTO.class
                );

        return stkResponse.getBody();
    }

}

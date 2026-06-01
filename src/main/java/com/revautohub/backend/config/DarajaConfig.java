package com.revautohub.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DarajaConfig {

    // Consumer key from Daraja portal
    @Value("${daraja.consumer-key}")
    private String consumerKey;

    // Consumer secret from Daraja portal
    @Value("${daraja.consumer-secret}")
    private String consumerSecret;

    // M-Pesa business shortcode
    @Value("${daraja.short-code}")
    private String shortCode;

    // Daraja passkey
    @Value("${daraja.passkey}")
    private String passKey;

    // Callback URL
    @Value("${daraja.callback-url}")
    private String callbackUrl;

    // Account reference
    @Value("${daraja.account-reference}")
    private String accountReference;

    // Transaction description
    @Value("${daraja.transaction-desc}")
    private String transactionDesc;

    // OAuth URL
    @Value("${daraja.oauth-url}")
    private String oauthUrl;

    // STK Push URL
    @Value("${daraja.stk-push-url}")
    private String stkPushUrl;

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getPassKey() {
        return passKey;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public String getOauthUrl() {
        return oauthUrl;
    }

    public String getStkPushUrl() {
        return stkPushUrl;
    }
}
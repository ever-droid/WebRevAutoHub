package com.revautohub.backend.payment.dto;

import java.time.LocalDateTime;

public class PaymentResponseDTO {
    // Payment status, for example SUCCESS or FAILED
    private String status;

    // Confirmation message returned after payment processing
    private String message;

    // Simulated M-Pesa transaction code
    private String transactionCode;

    // Amount paid
    private Double amount;

    // Phone number used for payment
    private String phoneNumber;

    // Payment reference
    private String reference;

    // Time payment was processed
    private LocalDateTime paymentTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

}

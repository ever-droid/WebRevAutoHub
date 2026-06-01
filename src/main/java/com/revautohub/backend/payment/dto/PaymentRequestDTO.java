package com.revautohub.backend.payment.dto;

public class PaymentRequestDTO {

    // Phone number making the M-Pesa payment
    private String phoneNumber;

    // Amount to be paid
    private Double amount;

    // Order or product reference being paid for
    private String reference;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}

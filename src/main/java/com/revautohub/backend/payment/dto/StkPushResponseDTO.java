package com.revautohub.backend.payment.dto;

public class StkPushResponseDTO {


    // Merchant request ID returned by Daraja
    private String MerchantRequestID;

    // Checkout request ID returned by Daraja
    private String CheckoutRequestID;

    // Response code from Daraja
    private String ResponseCode;

    // Response description from Daraja
    private String ResponseDescription;

    // Customer message returned by Daraja
    private String CustomerMessage;

    public String getMerchantRequestID() {
        return MerchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        MerchantRequestID = merchantRequestID;
    }

    public String getCheckoutRequestID() {
        return CheckoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        CheckoutRequestID = checkoutRequestID;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseDescription() {
        return ResponseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        ResponseDescription = responseDescription;
    }

    public String getCustomerMessage() {
        return CustomerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        CustomerMessage = customerMessage;
    }



}

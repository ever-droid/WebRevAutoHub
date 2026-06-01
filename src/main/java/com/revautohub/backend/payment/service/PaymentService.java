package com.revautohub.backend.payment.service;

import com.revautohub.backend.payment.dto.PaymentRequestDTO;
import com.revautohub.backend.payment.dto.PaymentResponseDTO;
import com.revautohub.backend.payment.dto.StkPushResponseDTO;

public interface PaymentService {

    // Receive payment details from frontend,
    // send STK Push request to Daraja,
    // and return Daraja response
    StkPushResponseDTO stkPush(
            PaymentRequestDTO paymentRequestDTO
    );

}

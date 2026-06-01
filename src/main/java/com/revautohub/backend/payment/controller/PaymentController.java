package com.revautohub.backend.payment.controller;


import com.revautohub.backend.payment.dto.PaymentRequestDTO;
import com.revautohub.backend.payment.dto.PaymentResponseDTO;
import com.revautohub.backend.payment.dto.StkPushResponseDTO;
import com.revautohub.backend.payment.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    // Service used to handle payment logic
    private final PaymentService paymentService;

    // Constructor injection
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Receive payment details from frontend,
    // send STK Push request through service,
    // and return Daraja response
    @PostMapping("/stk-push")
    public ResponseEntity<StkPushResponseDTO> stkPush(
            @RequestBody PaymentRequestDTO paymentRequestDTO) {

        StkPushResponseDTO responseDTO =
                paymentService.stkPush(paymentRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

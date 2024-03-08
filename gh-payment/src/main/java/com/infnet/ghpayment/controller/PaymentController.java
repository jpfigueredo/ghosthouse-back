package com.infnet.ghpayment.controller;

import com.infnet.ghpayment.dto.PaymentDTO;
import com.infnet.ghpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO paymentDto) {
        PaymentDTO processedPayment = paymentService.processPayment(paymentDto);
        return new ResponseEntity<>(processedPayment, HttpStatus.CREATED);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long paymentId) {
        PaymentDTO paymentDto = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(paymentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> cancelPayment(@PathVariable Long paymentId) {
        paymentService.cancelPayment(paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

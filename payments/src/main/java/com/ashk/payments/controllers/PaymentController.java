package com.ashk.payments.controllers;


import com.ashk.payments.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-order")
    public String createOrder(@RequestParam int amount){
        try {
            return paymentService.createOrder(amount, "INR", "123");
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}

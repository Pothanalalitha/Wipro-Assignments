package com.example.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wipro.entities.Payment;
import com.example.wipro.feign.PaymentInterface;

@Service
public class notificationServiceImpl implements notifictaionService 
{
	@Autowired
    private PaymentInterface paymentClient;
	public String showOrderPlacedMessage(Long paymentId) {
        Payment payment = paymentClient.getPaymentById(paymentId);
        if (payment != null && "SUCCESS".equalsIgnoreCase(payment.getStatus())) {
            return "Order placed successfully";
        }
        return "Order placement failed";
    }
}

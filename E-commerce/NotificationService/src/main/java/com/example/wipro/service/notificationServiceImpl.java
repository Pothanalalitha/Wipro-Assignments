package com.example.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.wipro.entities.Payment;
import com.example.wipro.feign.PaymentInterface;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Service
@Tag(name = "Notification Service", description = "Handles order placement notifications")
public class notificationServiceImpl implements notifictaionService {

    private static final Logger logger = LoggerFactory.getLogger(notificationServiceImpl.class);

    @Autowired
    private PaymentInterface paymentClient;

    private static final String CIRCUIT_BREAKER_NAME = "paymentClient";

    @Operation(summary = "Show order placement message based on payment status")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "orderPlacementFallback")
    public String showOrderPlacedMessage(Long paymentId) {
        logger.info("Fetching payment status for payment ID: {}", paymentId);

        Payment payment = paymentClient.getPaymentById(paymentId);

        if (payment != null && "SUCCESS".equalsIgnoreCase(payment.getStatus())) {
            logger.info("Payment successful for ID: {}, sending success message", paymentId);
            return "Order placed successfully";
        }

        logger.warn("Payment failed or not found for ID: {}", paymentId);
        return "Order placement failed";
    }

    // 🔹 Fallback method (must have same return type + params + Exception)
    public String orderPlacementFallback(Long paymentId, Throwable t) {
        logger.error("Circuit breaker triggered for payment ID {}. Cause: {}", paymentId, t.getMessage());
        return "Order service is temporarily unavailable. Please try again later.";
    }
}

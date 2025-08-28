package com.example.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.wipro.entities.OrderEntity;
import com.example.wipro.entities.Payment;
import com.example.wipro.feign.OrderFeignClient;
import com.example.wipro.repository.paymentRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@Tag(name = "Payment Service", description = "Handles payment-related operations")
public class paymentServiceImpl implements paymentService {

    private static final Logger logger = LoggerFactory.getLogger(paymentServiceImpl.class);

    public static class PaymentException extends RuntimeException {
        public PaymentException(String message) {
            super(message);
        }
    }

    @Autowired
    private paymentRepository repo; 

    @Autowired
    private OrderFeignClient orderClient;

    @Override
    @Operation(summary = "Perform payment for a specific order")
    @CircuitBreaker(name = "orderServiceCB", fallbackMethod = "orderServiceFallback")
    public Payment doPayment(Long orderId) {
        logger.info("Initiating payment for order ID: {}", orderId);

        OrderEntity order = orderClient.getOrderById(orderId);

        if (order == null) {
            logger.error("Order not found for ID: {}", orderId);
            throw new PaymentException("Order not found");
        }

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(order.getTotalAmount());
        payment.setStatus("SUCCESS");

        Payment saved = repo.save(payment);
        logger.info("Payment successful for order ID: {}", orderId);
        return saved;
    }

    // ✅ Fallback if Order Service is down/unreachable
    public Payment orderServiceFallback(Long orderId, Throwable t) {
        logger.error("Fallback executed for orderId: {} | Reason: {}", orderId, t.getMessage());
        Payment fallbackPayment = new Payment();
        fallbackPayment.setOrderId(orderId);
        fallbackPayment.setAmount(0.0);
        fallbackPayment.setStatus("FAILED - Order Service unavailable");
        return fallbackPayment;
    }

    @Override
    @Operation(summary = "Get payment details by payment ID")
    public Payment getPaymentById(Long id) {
        logger.info("Fetching payment with ID: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Payment not found with ID: {}", id);
                    return new PaymentException("Payment not found");
                });
    }
}

package com.example.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wipro.entities.OrderEntity;
import com.example.wipro.entities.Payment;
import com.example.wipro.feign.OrderFeignClient;
import com.example.wipro.repository.productRepository;

@Service
public class paymentServiceImpl implements paymentService 
{
	@Autowired
  private productRepository repo;
	public class PaymentException extends RuntimeException {
        public PaymentException(String message) 
        { 
        	super(message); 
        	}
    }
	@Autowired
    private OrderFeignClient orderClient;

    @Override
    public Payment doPayment(Long orderId) {
        try {
            OrderEntity order = orderClient.getOrderById(orderId);
            if (order == null) {
                throw new PaymentException("Order not found");
            }
            Payment payment = new Payment();
            payment.setOrderId(orderId);
            payment.setAmount(order.getTotalAmount());
            payment.setStatus("SUCCESS");
            return repo.save(payment);
        } catch (Exception e) {
            throw new PaymentException("Payment failed: " + e.getMessage());
        }
    }
    @Override
    public Payment getPaymentById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new PaymentException("Payment not found"));
    }
}


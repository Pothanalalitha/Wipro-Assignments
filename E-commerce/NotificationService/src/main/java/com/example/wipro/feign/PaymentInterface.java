package com.example.wipro.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wipro.entities.Payment;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentInterface
{
	@GetMapping("/api/v4/payment/getPaymentById/{id}")
    Payment getPaymentById(@PathVariable Long id);
}

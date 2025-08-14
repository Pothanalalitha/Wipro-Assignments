package com.example.wipro.service;

import com.example.wipro.entities.Payment;

public interface paymentService 
{

	Payment doPayment(Long orderId);

	Payment getPaymentById(Long id);

}

package com.example.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wipro.entities.Payment;
import com.example.wipro.service.paymentService;

@RestController
@RequestMapping("/api/v4/payment")
public class paymentController 
{
	@Autowired
  private paymentService service;
	
	@PostMapping("/pay/{orderId}")
    public Payment pay(@PathVariable Long orderId)
	{
        return service.doPayment(orderId);
    }
	@GetMapping("/getPaymentById/{id}")
	public Payment getPaymentById(@PathVariable Long id) 
	{
	    return service.getPaymentById(id);
	}
}

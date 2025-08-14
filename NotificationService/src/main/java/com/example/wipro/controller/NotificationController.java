package com.example.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wipro.service.notifictaionService;

@RestController
@RequestMapping("/ap1/v5/notification")
public class NotificationController
{
	@Autowired
  private notifictaionService service;
	@GetMapping("/showMessage/{paymentId}")
    public String showMessage(@PathVariable Long paymentId) 
	{
        return service.showOrderPlacedMessage(paymentId);
    }
}

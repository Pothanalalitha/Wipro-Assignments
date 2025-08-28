package com.example.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wipro.entities.Order;
import com.example.wipro.service.orderService;

@RestController
@RequestMapping("/api/v3/order")
public class orderController 
{
	@Autowired
  private orderService service;
	
	@PostMapping("/placeOrder/{cartId}")
    public Order placeOrder(@PathVariable Long cartId, @RequestParam String address)
	{
        return service.placeOrder(cartId, address);
    }

    @GetMapping("/getStatus/{id}")
    public Order getOrderStatus(@PathVariable Long id) 
    {
        return service.getOrderStatus(id);
    }

    @PatchMapping("/cancelOrder/{id}")
    public Order cancelOrder(@PathVariable Long id)
    {
        return service.cancelOrder(id);
    }
}

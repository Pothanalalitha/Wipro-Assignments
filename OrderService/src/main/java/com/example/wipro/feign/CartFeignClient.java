package com.example.wipro.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wipro.entities.Cart;

@FeignClient(name = "CART-SERVICE")
public interface CartFeignClient 
{
	@GetMapping("/api/v1/cart/getcartByID/{id}")
    Cart getCartById(@PathVariable Long id);
}


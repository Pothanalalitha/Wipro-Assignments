package com.example.wipro.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wipro.entites.Product;


@FeignClient(name="PRODUCT-SERVICE")
public interface CartInterface 
{
	@GetMapping("/api/v1/products/getByID/{id}")
    Product getProductById(@PathVariable Long id);
} 

package com.example.wipro.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wipro.entities.OrderEntity;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderFeignClient 
{
	@GetMapping("/api/v3/order/getStatus/{id}")
    OrderEntity getOrderById(@PathVariable Long id);
}

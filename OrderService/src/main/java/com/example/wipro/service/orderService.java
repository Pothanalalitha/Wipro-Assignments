package com.example.wipro.service;

import java.util.List;

import com.example.wipro.entities.Order;

public interface orderService 
{

	

	Order placeOrder(Long cartId, String address);

	Order getOrderStatus(Long id);

	Order cancelOrder(Long id);

	


}

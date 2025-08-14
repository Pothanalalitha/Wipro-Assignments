package com.example.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wipro.entities.Cart;
import com.example.wipro.entities.Order;
import com.example.wipro.feign.CartFeignClient;
import com.example.wipro.repository.orderRepository;

@Service
public class orderServiceImpl implements orderService 
{
	@Autowired
	private orderRepository repo;
	@Autowired
	private CartFeignClient  cartClient;
	
	public class OrderException extends RuntimeException 
	{
	    public OrderException(String message) {
	        super(message);
	    }
	}
	
	 @Override
	    public Order placeOrder(Long cartId, String address) 
	 {
	        Cart cart = cartClient.getCartById(cartId);
	        if (cart == null)
	        {
	            throw new OrderException("Cart not found for placing order");
	        }

	        Order order = new Order();
	        order.setCartId(cartId);
	        order.setAddress(address);
	        order.setStatus("PLACED");
	        order.setTotalAmount(cart.getProductPrice() * cart.getQuantity());
	        return repo.save(order);
	    }

	    @Override
	    public Order getOrderStatus(Long id)
	    {
	        return repo.findById(id)
	                .orElseThrow(() -> new OrderException("Order not found"));
	    }

	    @Override
	    public Order cancelOrder(Long id)
	    {
	        Order order = repo.findById(id)
	                .orElseThrow(() -> new OrderException("Order not found"));
	        order.setStatus("CANCELLED");
	        return repo.save(order);
	    }
	}



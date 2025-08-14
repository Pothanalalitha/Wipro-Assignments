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
import org.springframework.web.bind.annotation.RestController;

import com.example.wipro.entites.Cart;
import com.example.wipro.services.cartService;

@RestController
@RequestMapping("/api/v1/cart")
public class cartController 
{
	@Autowired
  private cartService service;
	
	 @PostMapping("/addToCart")
	    public Cart addToCart(@RequestBody Cart cart)
	 {
	        return service.addToCart(cart);
	    }

	    @GetMapping("/getAllCarts")
	    public List<Cart> getAllCartItems()
	    {
	        return service.getAllCartItems();
	    }

	    @GetMapping("getcartByID/{id}")
	    public Cart getCartItem(@PathVariable Long id) 
	    {
	        return service.getCartById(id);
	    }

	    @PatchMapping("updateCartById/{id}")
	    public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart) 
	    {
	        return service.updateCart(id, cart);
	    }
	    @DeleteMapping("deleteCartById/{id}")
	    public String deleteCart(@PathVariable Long id) 
	    {
	        service.deleteCart(id);
	        return "Cart item deleted";
	    }
	}

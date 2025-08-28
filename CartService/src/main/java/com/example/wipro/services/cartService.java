package com.example.wipro.services;

import java.util.List;

import com.example.wipro.entites.Cart;

public interface cartService 
{

	Cart addToCart(Cart cart);

	List<Cart> getAllCartItems();

	Cart getCartById(Long id);

	Cart updateCart(Long id, Cart cart);

	void deleteCart(Long id);

}

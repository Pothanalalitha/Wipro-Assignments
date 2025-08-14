package com.example.wipro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wipro.entites.Cart;
import com.example.wipro.entites.Product;
import com.example.wipro.feign.CartInterface;
import com.example.wipro.repository.cartRepository;

@Service
public class cartServiceImpl implements cartService
{
	@Autowired
  private cartRepository repo;
	
	@Autowired
    private CartInterface productClient;
	public class CartException extends RuntimeException {
	    public CartException(String message) {
	        super(message);
	    }
	}

    @Override
    public Cart addToCart(Cart cart)
    {
        Product product = productClient.getProductById(cart.getProductId());
        if (product == null) {
            throw new CartException("Product not found");
        }
        cart.setProductPrice(product.getProductPrice());
        return repo.save(cart);
    }

    @Override
    public List<Cart> getAllCartItems() 
    {
        return repo.findAll();
    }

    
    @Override
    public Cart getCartById(Long id) 
    {
        return repo.findById(id)
                .orElseThrow(() -> new CartException("Cart item not found"));
    }

    @Override
    public Cart updateCart(Long id, Cart partialCart) 
    {
        Cart existing = repo.findById(id)
                .orElseThrow(() -> new CartException("Cart not found"));

        if (partialCart.getQuantity() != null) {
            existing.setQuantity(partialCart.getQuantity());
        }

        Product product = productClient.getProductById(existing.getProductId());
        if (product != null) {
            existing.setProductPrice(product.getProductPrice());
        }

        return repo.save(existing);
    }

    @Override
    public void deleteCart(Long id)
    {
        if (!repo.existsById(id))
        {
            throw new CartException("Cart item not found");
        }
        repo.deleteById(id);
    }
}

package com.example.wipro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wipro.entites.Cart;
import com.example.wipro.entites.Product;
import com.example.wipro.feign.CartInterface;
import com.example.wipro.repository.cartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Service
@Tag(name = "Cart Service", description = "Handles cart-related operations")
public class cartServiceImpl implements cartService 
{

    private static final Logger logger = LoggerFactory.getLogger(cartServiceImpl.class);

    public static class CartException extends RuntimeException {
        public CartException(String message) {
            super(message);
        }
    }

    @Autowired
    private cartRepository repo;

    @Autowired
    private CartInterface productClient;

    @Override
    @Operation(summary = "Add item to cart")
    public Cart addToCart(Cart cart) {
        logger.info("Adding product ID {} to cart", cart.getProductId());
        Product product = productClient.getProductById(cart.getProductId());

        if (product == null) {
            logger.error("Product with ID {} not found", cart.getProductId());
            throw new CartException("Product not found");
        }

        cart.setProductPrice(product.getProductPrice());
        Cart savedCart = repo.save(cart);
        logger.info("Cart item saved: {}", savedCart);
        return savedCart;
    }
    @Override
    @Operation(summary = "Get all cart items")
    public List<Cart> getAllCartItems() {
        logger.info("Fetching all cart items");
        return repo.findAll();
    }

 
    @Override
    @Operation(summary = "Get cart item by ID")
    public Cart getCartById(Long id) {
        logger.info("Fetching cart item with ID: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Cart item with ID {} not found", id);
                    return new CartException("Cart item not found");
                });
    }

    @Override
    @Operation(summary = "Update cart item by ID")
    public Cart updateCart(Long id, Cart partialCart) {
        logger.info("Updating cart item with ID: {}", id);
        Cart existing = repo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Cart item with ID {} not found", id);
                    return new CartException("Cart not found");
                });

        if (partialCart.getQuantity() != null) {
            existing.setQuantity(partialCart.getQuantity());
        }

        Product product = productClient.getProductById(existing.getProductId());
        if (product != null) {
            existing.setProductPrice(product.getProductPrice());
        }

        Cart updatedCart = repo.save(existing);
        logger.info("Cart item with ID {} updated successfully", id);
        return updatedCart;
    }

    @Override
    @Operation(summary = "Delete cart item by ID")
    public void deleteCart(Long id) {
        logger.info("Attempting to delete cart item with ID: {}", id);
        if (!repo.existsById(id)) {
            logger.error("Cart item with ID {} not found", id);
            throw new CartException("Cart item not found");
        }

        repo.deleteById(id);
        logger.info("Cart item with ID {} deleted", id);
    }
}

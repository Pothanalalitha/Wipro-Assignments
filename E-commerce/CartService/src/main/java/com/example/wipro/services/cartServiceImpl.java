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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Service
@Tag(name = "Cart Service", description = "Handles cart-related operations")
public class cartServiceImpl implements cartService {

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

    // Circuit breaker enabled method
    @CircuitBreaker(name = "productService", fallbackMethod = "getProductByIdFallback")
    public Product fetchProduct(Long id) {
        return productClient.getProductById(id);
    }

    // Fallback for when product service is down/unreachable
    public Product getProductByIdFallback(Long id, Throwable ex) {
        logger.error("Fallback triggered for Product ID {} due to: {}", id, ex.getMessage());
        Product p = new Product();
        p.setId(id);
        p.setProductName("Unavailable");
        p.setProductCategory("unknown"); 
        p.setProductPrice(0.0);
        p.setProductQuantity(0);
        return p;
    }

    @Override
    @Operation(summary = "Add item to cart")
    public Cart addToCart(Cart cart) {
        logger.info("Adding product ID {} to cart", cart.getProductId());
        Product product = fetchProduct(cart.getProductId()); // ✅ Circuit breaker applied

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

        Product product = fetchProduct(existing.getProductId()); // ✅ Circuit breaker applied
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

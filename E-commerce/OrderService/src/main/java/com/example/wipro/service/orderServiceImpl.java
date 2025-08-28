package com.example.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.wipro.entities.Cart;
import com.example.wipro.entities.Order;
import com.example.wipro.feign.CartFeignClient;
import com.example.wipro.repository.orderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Service
@Tag(name = "Order Service", description = "Handles order-related operations")
public class orderServiceImpl implements orderService {

    private static final Logger logger = LoggerFactory.getLogger(orderServiceImpl.class);

    public static class OrderException extends RuntimeException {
        public OrderException(String message) {
            super(message);
        }
    }

    @Autowired
    private orderRepository repo;

    @Autowired
    private CartFeignClient cartClient;

    // ✅ Fallback-enabled Cart fetch
    @CircuitBreaker(name = "cartService", fallbackMethod = "getCartByIdFallback")
    public Cart fetchCart(Long cartId) {
        return cartClient.getCartById(cartId);
    }

    // ✅ Fallback method
    public Cart getCartByIdFallback(Long cartId, Throwable ex) {
        logger.error("Cart Service unavailable, fallback triggered for cartId: {}", cartId, ex);
        Cart fallbackCart = new Cart();
        fallbackCart.setId(cartId);
        fallbackCart.setProductId(0L);
        fallbackCart.setProductPrice(0.0);
        fallbackCart.setQuantity(0);
        return fallbackCart;
    }

    @Override
    @Operation(summary = "Place an order using cart ID and address")
    public Order placeOrder(Long cartId, String address) {
        logger.info("Placing order for cart ID: {}, address: {}", cartId, address);

        Cart cart = fetchCart(cartId);
        if (cart == null || cart.getQuantity() == 0) {
            logger.error("Invalid or unavailable cart for ID: {}", cartId);
            throw new OrderException("Cart not available for placing order");
        }

        Order order = new Order();
        order.setCartId(cartId);
        order.setAddress(address);
        order.setStatus("PLACED");
        order.setTotalAmount(cart.getProductPrice() * cart.getQuantity());

        Order savedOrder = repo.save(order);
        logger.info("Order placed successfully: {}", savedOrder);
        return savedOrder;
    }

    @Override
    @Operation(summary = "Get order status by ID")
    public Order getOrderStatus(Long id) {
        logger.info("Fetching order status for ID: {}", id);

        return repo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Order not found with ID: {}", id);
                    return new OrderException("Order not found");
                });
    }

    @Override
    @Operation(summary = "Cancel order by ID")
    public Order cancelOrder(Long id) {
        logger.info("Cancelling order with ID: {}", id);

        Order order = repo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Order not found for cancellation, ID: {}", id);
                    return new OrderException("Order not found");
                });

        order.setStatus("CANCELLED");
        Order updatedOrder = repo.save(order);

        logger.info("Order with ID: {} cancelled successfully", id);
        return updatedOrder;
    }
}

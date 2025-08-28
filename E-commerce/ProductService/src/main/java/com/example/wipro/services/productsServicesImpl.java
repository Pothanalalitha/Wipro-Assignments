package com.example.wipro.services;

import com.example.wipro.enums.Category;
import com.example.wipro.entities.Product;
import com.example.wipro.repositroy.productRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Tag(name = "Product Service", description = "Handles product-related operations")
public class productsServicesImpl implements productService {

    private static final Logger logger = LoggerFactory.getLogger(productsServicesImpl.class);

    public static class ProductException extends RuntimeException {
        public ProductException(String message) {
            super(message);
        }
    }

    @Autowired
    private productRepository repo;

    @Override
    @Operation(summary = "Add a new product")
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackAdd")
    public Product add(Product p) {
        logger.info("Adding new product: {}", p);
        return repo.save(p);
    }

    public Product fallbackAdd(Product p, Throwable t) {
        logger.error("Add Product failed: {}", t.getMessage());
        Product fallbackProduct = new Product();
        fallbackProduct.setProductName("N/A");
        fallbackProduct.setProductCategory(Category.UNKNOWN);
        fallbackProduct.setProductPrice(0.0);
        fallbackProduct.setProductQuantity(0);
        return fallbackProduct;
    }

    @Operation(summary = "Get a product by ID")
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGet")
    public Product get(Long id) {
        logger.info("Fetching product with ID: {}", id);
        return repo.findById(id).orElseThrow(() -> {
            logger.error("Product with ID {} not found", id);
            return new ProductException("Product not found");
        });
    }

    public Product fallbackGet(Long id, Throwable t) {
        logger.error("Get Product failed: {}", t.getMessage());
        Product fallbackProduct = new Product();
        fallbackProduct.setProductName("N/A");
        fallbackProduct.setProductCategory(Category.UNKNOWN);
        fallbackProduct.setProductPrice(0.0);
        fallbackProduct.setProductQuantity(0);
        return fallbackProduct;
    }

    @Override
    @Operation(summary = "Get products by category (paginated)")
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetByCategory")
    public Page<Product> getByCategory(Pageable pageable) {
        logger.info("Fetching products with pageable: {}", pageable);
        return repo.findAll(pageable);
    }

    public Page<Product> fallbackGetByCategory(Pageable pageable, Throwable t) {
        logger.error("Get By Category failed: {}", t.getMessage());
        return Page.empty(pageable);
    }

    @Operation(summary = "Update product partially by ID")
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackUpdatePartial")
    public Product updatePartial(Long id, Product partialProduct) {
        logger.info("Updating product partially with ID: {}", id);
        Product existing = repo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Product with ID {} not found for update", id);
                    return new ProductException("Product not found");
                });

        if (partialProduct.getProductName() != null) {
            existing.setProductName(partialProduct.getProductName());
        }
        if (partialProduct.getProductCategory() != null) {
            existing.setProductCategory(partialProduct.getProductCategory());
        }
        if (partialProduct.getProductPrice() != 0) {
            existing.setProductPrice(partialProduct.getProductPrice());
        }
        if (partialProduct.getProductQuantity() != 0) {
            existing.setProductQuantity(partialProduct.getProductQuantity());
        }

        return repo.save(existing);
    }

    public Product fallbackUpdatePartial(Long id, Product partialProduct, Throwable t) {
        logger.error("Update Partial failed: {}", t.getMessage());
        Product fallbackProduct = new Product();
        fallbackProduct.setProductName("N/A");
        fallbackProduct.setProductCategory(Category.UNKNOWN);
        fallbackProduct.setProductPrice(0.0);
        fallbackProduct.setProductQuantity(0);
        return fallbackProduct;
    }

    @Override
    @Operation(summary = "Delete product by ID")
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackDelete")
    public void delete(Long id) {
        logger.info("Deleting product with ID: {}", id);
        repo.deleteById(id);
        logger.info("Product with ID {} deleted", id);
    }

    public void fallbackDelete(Long id, Throwable t) {
        logger.error("Delete Product failed for ID {}: {}", id, t.getMessage());
    }
}

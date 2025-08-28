package com.example.wipro.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.wipro.entities.Product;

public interface productService 
{

	Product add(Product p);

	Product get(Long id);

	Page<Product> getByCategory(Pageable pageable);

	Product updatePartial(Long id, Product partialProduct);

	void delete(Long id);

}

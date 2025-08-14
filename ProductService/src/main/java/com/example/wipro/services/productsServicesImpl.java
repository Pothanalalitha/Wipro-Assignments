package com.example.wipro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.wipro.entities.Product;
import com.example.wipro.repositroy.productRepository;

@Service
public class productsServicesImpl implements productService 
{
	public class ProductException extends RuntimeException {
	    public ProductException(String message) {
	        super(message);
	    }
	}
	@Autowired
  private productRepository repo;

	@Override
	public Product add(Product p)
	{
		return repo.save(p);
	}
	public Product get(Long id)
	{
        return repo.findById(id).orElseThrow(() -> new ProductException("Product not found"));
    }
	@Override
	public Page<Product> getByCategory(Pageable pageable) 
	{
		return repo.findAll(pageable);
	}
	public Product updatePartial(Long id, Product partialProduct) {
		Product existing = repo.findById(id)
		        .orElseThrow(() -> new ProductException("Product not found"));

		    if (partialProduct.getProductName() != null)
		        existing.setProductName(partialProduct.getProductName());

		    if (partialProduct.getProductCategory() != null)
		        existing.setProductCategory(partialProduct.getProductCategory());

		    if (partialProduct.getProductPrice() != 0)
		        existing.setProductPrice(partialProduct.getProductPrice());

		    if (partialProduct.getProductQuantity() != 0)
		        existing.setProductQuantity(partialProduct.getProductQuantity());

		    return repo.save(existing);
	}
	@Override
	public void delete(Long id) 
	{
		repo.deleteById(id);
		
	}
}

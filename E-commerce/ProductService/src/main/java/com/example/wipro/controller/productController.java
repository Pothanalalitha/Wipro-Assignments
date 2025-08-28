package com.example.wipro.controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wipro.entities.Product;
import com.example.wipro.services.productService;

@RestController
@RequestMapping("/api/v1/products")
public class productController 
{
	@Autowired
   private productService service;
	
	@PostMapping("/addProducts") 
	public Product add(@RequestBody Product p)
	{ 
		return service.add(p); 
    }
	
	 @GetMapping("/getByID/{id}") 
	 public Product get(@PathVariable Long id) 
	 { 
		 return service.get(id); 
	 
	 }
	   @GetMapping("/getByCategory")
	    public Page<Product> category(Pageable pageable) 
	   {
	        return service.getByCategory(pageable);
	    }
	   @PatchMapping("/UpdateProduct/{id}")
	   public Product patchUpdate(@PathVariable Long id, @RequestBody Product partialProduct) 
	   {
	       return service.updatePartial(id, partialProduct);
	   }
	    @DeleteMapping("/DeleteById/{id}") 
	    public String delete(@PathVariable Long id) 
	    { 
	    	service.delete(id); 
	    	return "product deleted successfuly";
	    	
	    }
	    
}

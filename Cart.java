package com.example.wipro.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Long productId;  
    private Integer quantity;
    private Double ProductPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(Double productPrice) {
		ProductPrice = productPrice;
	}
	public Cart() {
		super();
	}
	public Cart(Long productId, Integer quantity, Double productPrice) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		ProductPrice = productPrice;
	}
	
    
}

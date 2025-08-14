package com.example.wipro.entities;

public class Cart
{
	private Long id;
    private Long productId;
    private Integer quantity;
    private Double productPrice;
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
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Cart() {
		super();
	}
	public Cart(Long id, Long productId, Integer quantity, Double productPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}
	
	
	
    
}

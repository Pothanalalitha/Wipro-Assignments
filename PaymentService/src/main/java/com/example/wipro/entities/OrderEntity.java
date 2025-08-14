package com.example.wipro.entities;

public class OrderEntity 
{
	private Long id;
    private Long cartId;
    private String address;
    private String status;
    private Double totalAmount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public OrderEntity() {
		super();
	}
	public OrderEntity(Long id, Long cartId, String address, String status, Double totalAmount) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.address = address;
		this.status = status;
		this.totalAmount = totalAmount;
	}
	
    
}

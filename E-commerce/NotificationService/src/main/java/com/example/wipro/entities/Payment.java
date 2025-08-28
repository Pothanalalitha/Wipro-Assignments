package com.example.wipro.entities;

public class Payment 
{
	private Long id;
    private Long orderId;
    private Double amount;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Payment() {
		super();
	}
	public Payment(Long id, Long orderId, Double amount, String status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.amount = amount;
		this.status = status;
	}
    
}

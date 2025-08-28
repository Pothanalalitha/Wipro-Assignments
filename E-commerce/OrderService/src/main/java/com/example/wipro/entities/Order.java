package com.example.wipro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order 
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
		public Order() {
			super();
		}
		public Order(Long cartId, String address, String status, Double totalAmount) {
			super();
			this.cartId = cartId;
			this.address = address;
			this.status = status;
			this.totalAmount = totalAmount;
		}
}

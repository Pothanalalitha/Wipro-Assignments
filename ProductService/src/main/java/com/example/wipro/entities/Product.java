package com.example.wipro.entities;

import com.example.wipro.enums.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product 
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String productName;
	 @Enumerated(EnumType.STRING)
	 private Category productCategory;
	 private double productPrice;
	 private int productQuantity;
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getProductName() {
		 return productName;
	 }
	 public void setProductName(String productName) {
		 this.productName = productName;
	 }
	 public Category getProductCategory() {
		 return productCategory;
	 }
	 public void setProductCategory(Category productCategory) {
		 this.productCategory = productCategory;
	 }
	 public double getProductPrice() {
		 return productPrice;
	 }
	 public void setProductPrice(double productPrice) {
		 this.productPrice = productPrice;
	 }
	 public int getProductQuantity() {
		 return productQuantity;
	 }
	 public void setProductQuantity(int productQuantity) {
		 this.productQuantity = productQuantity;
	 }
	 public Product() {
		super();
	 }
	 public Product(String productName, Category productCategory, double productPrice, int productQuantity) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	 }

}

package com.example.wipro.entites;

public class Product 
{
	private Long id;              
    private String productName;
    private String productCategory;
    private Double productPrice;
    private Integer productQuantity;
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
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Product() {
		super();
	}
	public Product(Long id, String productName, String productCategory, Double productPrice, Integer productQuantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
    
}

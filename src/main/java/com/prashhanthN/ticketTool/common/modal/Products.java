package com.prashhanthN.ticketTool.common.modal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	private int productId;
	private Long productPrice;
	private String product;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productPrice=" + productPrice + ", product=" + product + "]";
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

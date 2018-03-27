package com.online.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private String productId;

	private String productName;
	
	private String productDescription;
	
	private String relatedProduct;
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public String getRelatedProduct() {
		return relatedProduct;
	}
	
	public void setRelatedProduct(String relatedProduct) {
		this.relatedProduct = relatedProduct;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", relatedProduct=" + relatedProduct + "]";
	}
	
}

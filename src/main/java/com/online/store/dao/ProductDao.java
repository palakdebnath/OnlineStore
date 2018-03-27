package com.online.store.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.store.entity.Product;
import com.online.store.repository.ProductRepository;

@Service
public class ProductDao {
	
	@Autowired 
	private ProductRepository poductRepository;
	
	public List<Product> getAllProducts() {
		return poductRepository.findAll();
	}
	
	public Product getProductById(String productId) {
		return poductRepository.findOne(productId);
	}
	
	public void saveProduct(Product product) {
		poductRepository.save(product);
	}
	
	public void updateProduct(Product newProduct) {
		
		Product oldProduct = poductRepository.findOne(newProduct.getProductId());
		
		if(oldProduct != null) {
			oldProduct.setProductName(newProduct.getProductName());
			oldProduct.setProductDescription(newProduct.getProductDescription());
			oldProduct.setRelatedProduct(newProduct.getRelatedProduct());
			poductRepository.save(oldProduct);
		}
	}
	
	public void deleteProductById(String productId) {
		poductRepository.delete(productId);
	}
}

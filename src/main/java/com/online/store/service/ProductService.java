package com.online.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.store.dao.ProductDao;
import com.online.store.entity.Product;

@Service
public class ProductService {

	@Autowired 
	private ProductDao productDao;
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
	}
	
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}
	
	public void updateProduct(Product newProduct) {
		productDao.updateProduct(newProduct);
	}
	
	public void deleteProductById(String productId) {
		productDao.deleteProductById(productId);
	}
}

package com.online.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.entity.Product;
import com.online.store.service.ProductService;

@RestController
@RequestMapping(value="/web/products")
public class ProductWebController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	@ResponseBody Product getProductById(@PathVariable String productId) {
		return productService.getProductById(productId);
	}

	@RequestMapping(value="", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody String saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return "Product details saved";
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody String updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return "Product details updated!";
	}

	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
	@ResponseBody String deleteProduct(@PathVariable String productId) {
		productService.deleteProductById(productId);
		return "Product deleted successfully!";
	}
}

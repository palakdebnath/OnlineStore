package com.online.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.online.store.entity.Product;
import com.online.store.service.ProductService;

@Controller
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView getAllProducts(ModelMap model) {
		List<Product> productList = productService.getAllProducts();
		model.put("products", productList);
		return new ModelAndView("productDisplay", model);
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public ModelAndView getProductById(@PathVariable String productId, ModelMap model) {
		Product product = productService.getProductById(productId);
		model.put("product", product);
		return new ModelAndView("productUpdate", model);
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public String updateProduct(@ModelAttribute Product product, ModelMap model) {
		productService.updateProduct(product);
		return "redirect:/products";
	}

	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
	public ModelAndView deleteProduct(@PathVariable String productId, ModelMap model) {
		productService.deleteProductById(productId);
		
		model.put("msg", "Product Deleted successfully");
		return new ModelAndView("redirect:/products", model);
	}
}

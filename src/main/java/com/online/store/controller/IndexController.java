package com.online.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.store.entity.Product;

@Controller
public class IndexController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String index(ModelMap model) {
        return "index";
    }
	
	@RequestMapping(value="/productDisplay", method=RequestMethod.GET)
	    public String productDisplay(ModelMap model) {
	        return "productDisplay";
	}
	
	@RequestMapping(value="/productCreate", method=RequestMethod.GET)
    public String productCreate(ModelMap model) {
		Product product = new Product();
		model.put("product", product);
        return "productCreate";
    }

}

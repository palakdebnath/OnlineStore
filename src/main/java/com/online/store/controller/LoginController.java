package com.online.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.store.entity.Product;
import com.online.store.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
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
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String showLoginPage(ModelMap model, @RequestParam String userName, @RequestParam String password) {
		
		boolean isValidUser = loginService.validateUser(userName, password);
		if(!isValidUser) {
			model.put("errorMsg", "Invalid credentials..");
			return "login";
		}
		System.out.println("User: " + userName + "Login successfull...");
		model.put("user", userName);
        return "redirect:/products";
    }
	
}

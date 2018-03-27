package com.online.store.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateUser(String name, String password) {
		return name.equalsIgnoreCase("user") && password.equalsIgnoreCase("pass");
	}

}

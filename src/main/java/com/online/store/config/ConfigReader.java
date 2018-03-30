package com.online.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigReader {

	@Value("${admin.userId}")
	private String adminUserId;
	
	@Value("${admin.password}")
	private String adminPassword;
	
	@Value("${user.userId}")
	private String userId;
	
	@Value("${user.password}")
	private String password;

	public String getAdminUserId() {
		return adminUserId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}
}

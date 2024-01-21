package com.gcu.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface UserServices 
{
	void registerUser(User user);

}

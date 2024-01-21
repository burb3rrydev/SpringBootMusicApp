package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;

/**
 * Login Controller
 */
@Controller
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private SecurityBusinessService security;
	
	/**
	 * Mapping for user login
	 * @param model Login Model
	 * @return Login View
	 */
	@GetMapping("/")
	public String display(Model model)
	{
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	/**
	 * Mapping after user logs in
	 * @param loginModel uses the LoginModel. it also checks to see if it's valid.
	 * @param bindingResult checks for errors
	 * @param model
	 * @return Main View 
	 */
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		//Check for validation errors
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		//authenticates user and if true, the user goes to main menu
		if(security.authenticate(loginModel.getUsername(), loginModel.getPassword()))
		{
			return "main";
		}

		//Navigates to the Login View
		return "login";
	}
}

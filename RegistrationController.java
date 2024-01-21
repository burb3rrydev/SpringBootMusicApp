package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.User;

import jakarta.validation.Valid;



@Controller
public class RegistrationController {
	private final UserServices userService;

    @Autowired
    public RegistrationController(UserServices userService) {
        this.userService = userService;
    }

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    return "registration"; // Updated to match the HTML file name
	}


    @PostMapping("/register")
    public String processRegistration(@Valid org.springframework.boot.autoconfigure.security.SecurityProperties.User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Log each field error
            bindingResult.getFieldErrors().forEach(fieldError -> 
                System.out.println("Field: " + fieldError.getField() + " - Error: " + fieldError.getDefaultMessage())
            );
            return "registration";
        }

        // TODO: Implement registration logic here
        // This might involve saving the user to a database (to be implemented in Milestone 4)
        userService.registerUser(user);

        return "redirect:/register-success"; // Redirect after successful registration
    }

}

package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;

import javax.validation.Valid;



@Controller
public class RegistrationController {
	
	private final UserRepository userRepository;
	
	@Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    return "registration"; // Updated to match the HTML file name
	}


    @PostMapping("/register")
    public String processRegistration(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Log each field error
            bindingResult.getFieldErrors().forEach(fieldError -> 
                System.out.println("Field: " + fieldError.getField() + " - Error: " + fieldError.getDefaultMessage())
            );
            return "registration";
        }

        userRepository.save(user);

        return "redirect:/register-success"; // Redirect after successful registration
    }
    @GetMapping("/register-success")
    public String showRegistrationSuccess() {
        return "register-success";
    }

}

package com.gcu;

import javax.validation.constraints.NotBlank;

public class User {
	@NotBlank(message = "First Name is required")
    private String firstName;
	
	@NotBlank(message = "Last Name is required")
    private String lastName;
	
	@NotBlank(message = "Email is required")
    private String email;
	
	@NotBlank(message = "Phone Number is required")
    private String phoneNumber;
	
	@NotBlank(message = "Username is required")
    private String username;
	
	@NotBlank(message = "Password is required")
    private String password;
	

    // Getters and setters
}
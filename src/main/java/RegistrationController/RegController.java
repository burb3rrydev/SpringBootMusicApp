package RegistrationController;

import com.gcu.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegController 
{
	@GetMapping("/register")
	public String showRegistrationForm (Model model)
	{
		model.addAttribute("user", new User());
		return "registration-form";
	}
	
	@PostMapping("/register")
	public String ProcessRegistration(@ModelAttribute("user") @Valid User user, BindingResult result) 
	{
		if (result.hasErrors()) 
		{
			return "registration-form";
		}
		//Registration logic that will be implemented in Milestone 4
		return "registration-sucess";
	}
}

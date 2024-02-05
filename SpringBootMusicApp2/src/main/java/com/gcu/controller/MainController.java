package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.MusicProduct;
import com.gcu.service.MusicProductService;

@Controller
public class MainController {
	@Autowired
    private MusicProductService musicProductService;

    @GetMapping("/main")
    public String home(Model model) {
        // Retrieve all music products from the database
        Iterable<MusicProduct> musicProducts = musicProductService.getAllProducts();

        // Add the music products to the model for rendering in the view
        model.addAttribute("musicProducts", musicProducts);

        return "main";
    }
    
    @GetMapping("/createProductPage")
    public String createProductPage(Model model) {
        model.addAttribute("product", new MusicProduct());
        return "createProduct"; // name of the product creation view
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("product") MusicProduct product, BindingResult result) {
        // Handle form submission logic, validation, and saving to the database
        
        // Redirect to another page after successful form submission
    	return "createProduct";
    }
}


package com.gcu.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gcu.model.MusicProduct;
import com.gcu.service.MusicProductService;

@Controller
public class ProductController {
    @Autowired
    private MusicProductService musicProductService;

    @GetMapping("/createProduct")
    public String showProductForm(Model model) {
        model.addAttribute("product", new MusicProduct());
        return "createProduct";
    }


    @PostMapping("/createProductForm")
    public String createProduct(@ModelAttribute("product") MusicProduct product,
                                @RequestParam("audioUrl") String audioUrl,
                                @RequestParam("pictureUrl") String pictureUrl,
                                Model model) {
        product.setAudioUrl(audioUrl);
        product.setPictureUrl(pictureUrl);

        try {
            // Save the product
            musicProductService.saveProduct(product);

            // Add success message to the model
            model.addAttribute("successMessage", "Product created successfully");
        } catch (Exception e) {
            // Add error message to the model
            model.addAttribute("errorMessage", "Failed to create product. Please try again.");

            // You may log the exception for further investigation
            e.printStackTrace();
        }

        // Return to the createProduct page
        return "createProduct";
    }







    private void saveFile(MultipartFile file, String filePath) {
        try {
            Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/templates" + filePath);
            
            // Debug statements
            System.out.println("Copying file to path: " + path);

            Files.createDirectories(path.getParent());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            
            // Debug statement
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            // Handle the exception (e.g., log it)
            System.err.println("Error copying file: " + e.getMessage());
            e.printStackTrace();
        }
    }



}


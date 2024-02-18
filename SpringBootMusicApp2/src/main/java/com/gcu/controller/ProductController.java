package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.gcu.model.MusicProduct;
import com.gcu.service.MusicProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private MusicProductService musicProductService;

    @GetMapping
    public ResponseEntity<List<MusicProduct>> getAllProducts() {
        Iterable<MusicProduct> productsIterable = musicProductService.getAllProducts();
        List<MusicProduct> products = new ArrayList<>();
        productsIterable.forEach(products::add);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<MusicProduct> getProductById(@PathVariable Long productId) {
        MusicProduct product = musicProductService.getProductById(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody MusicProduct product) {
        try {
            musicProductService.saveProduct(product);
            return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create product. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("audioFile") MultipartFile audioFile,
                                             @RequestParam("pictureFile") MultipartFile pictureFile,
                                             @RequestParam("name") String name,
                                             @RequestParam("artist") String artist) {
        // Create a new MusicProduct with the provided information
        MusicProduct product = new MusicProduct(name, artist, null, null);

        // Save the product to get its ID
        musicProductService.saveProduct(product);

        // Set the file paths for the product
        String audioFilePath = "/audio/" + product.getId() + ".mp3";
        String pictureFilePath = "/pictures/" + product.getId() + ".jpg";

        product.setAudioUrl(audioFilePath);
        product.setPictureUrl(pictureFilePath);

        // Save the updated product with file paths
        musicProductService.saveProduct(product);

        // Save audio and picture files
        saveFile(audioFile, audioFilePath);
        saveFile(pictureFile, pictureFilePath);

        return new ResponseEntity<>("Files uploaded successfully", HttpStatus.OK);
    }

    private void saveFile(MultipartFile file, String filePath) {
        // Your existing saveFile method
    }
}

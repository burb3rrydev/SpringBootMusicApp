package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.MusicProduct;
import com.gcu.repository.MusicProductRepository;

import java.util.Optional;

@Service
public class MusicProductService {
    @Autowired
    private MusicProductRepository musicProductRepository;

    public Iterable<MusicProduct> getAllProducts() {
        return musicProductRepository.findAll();
    }

    public MusicProduct getProductById(Long id) {
        Optional<MusicProduct> optionalProduct = musicProductRepository.findById(id);
        return optionalProduct.orElse(null); // Return null if not found, handle accordingly
    }

    public void saveProduct(MusicProduct product) {
        musicProductRepository.save(product);
    }
}

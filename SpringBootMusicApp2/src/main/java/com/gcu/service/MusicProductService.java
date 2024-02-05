package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.MusicProduct;
import com.gcu.repository.MusicProductRepository;

@Service
public class MusicProductService {
    @Autowired
    private MusicProductRepository musicProductRepository;

    public Iterable<MusicProduct> getAllProducts() {
        return musicProductRepository.findAll();
    }

    public void saveProduct(MusicProduct product) {
        musicProductRepository.save(product);
    }
}

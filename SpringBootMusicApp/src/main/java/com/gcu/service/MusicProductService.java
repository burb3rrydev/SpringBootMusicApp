package com.gcu.service;

import com.gcu.model.MusicProduct;
import com.gcu.repository.MusicProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

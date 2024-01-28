package com.gcu.repository;

import com.gcu.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // Additional custom query methods can be added here if needed
}
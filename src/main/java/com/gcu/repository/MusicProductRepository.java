package com.gcu.repository;

import com.gcu.model.MusicProduct;
import org.springframework.data.repository.CrudRepository;

public interface MusicProductRepository extends CrudRepository<MusicProduct, Long> {
    // Additional methods if needed
}

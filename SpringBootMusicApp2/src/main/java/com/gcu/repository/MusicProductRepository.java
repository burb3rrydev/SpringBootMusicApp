package com.gcu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.model.MusicProduct;

public interface MusicProductRepository extends JpaRepository<MusicProduct, Long> {
    // Add custom queries if needed
}

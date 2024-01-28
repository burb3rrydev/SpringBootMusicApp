package com.gcu.repository;


import com.gcu.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // You can add custom query methods if needed
}

package com.gcu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.gcu.repository") // Specify the correct base package for your repositories
public class JpaConfig {
    // You can add any additional JPA configurations here if needed
}
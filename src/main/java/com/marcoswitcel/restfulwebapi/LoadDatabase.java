package com.marcoswitcel.restfulwebapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marcoswitcel.restfulwebapi.repository.ProductRepository;
import com.marcoswitcel.restfulwebapi.model.Product;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product("TV", 1, 1500.00,1));
            productRepository.findAll().forEach(product -> {
                logger.info("Inserido: " + product);
            });
        };
    }

}

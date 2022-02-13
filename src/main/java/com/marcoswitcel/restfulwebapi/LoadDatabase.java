package com.marcoswitcel.restfulwebapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marcoswitcel.restfulwebapi.repository.ProductRepository;
import com.marcoswitcel.restfulwebapi.repository.ProductTypeRepository;
import com.marcoswitcel.restfulwebapi.model.Product;
import com.marcoswitcel.restfulwebapi.model.ProductType;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        return args -> {
            // Cadastro e log dos tipos
            ProductType productType01 = productTypeRepository.save(new ProductType("Eletrônicos"));
            ProductType productType02 = productTypeRepository.save(new ProductType("Papelaria"));
            ProductType productType03 = productTypeRepository.save(new ProductType("Higiene"));

            productTypeRepository.findAll().forEach(prodType -> {
                logger.info("Inserido Tipo: " + prodType);
            });

            productRepository.save(new Product("TV", productType01, 1500.00,12));
            productRepository.save(new Product("Livro do Harry Potter", productType02, 45.55,2));
            productRepository.save(new Product("Sabonete Líquido", productType03, 10.25,50));
            productRepository.findAll().forEach(product -> {
                logger.info("Inserido: " + product);
            });
        };
    }

}

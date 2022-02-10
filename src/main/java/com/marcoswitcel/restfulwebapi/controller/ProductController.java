package com.marcoswitcel.restfulwebapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcoswitcel.restfulwebapi.model.Product;
import com.marcoswitcel.restfulwebapi.repository.ProductRepository;


@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    /**
     * @TODO acho que seria interessante deixar essa rota como sendo o
     * getAll paginado dos produtos, talvez receber o orderby e outros
     *
     * @return Retorna a lista de produtos
     */
    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

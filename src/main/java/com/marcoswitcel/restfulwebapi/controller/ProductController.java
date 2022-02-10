package com.marcoswitcel.restfulwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.marcoswitcel.restfulwebapi.model.Product;
import com.marcoswitcel.restfulwebapi.repository.ProductRepository;
import com.marcoswitcel.restfulwebapi.exception.ProductNotFoundException;


@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Ação que retonar a lista com todos os atores
     *
     * @TODO acho que seria interessante deixar essa rota como sendo o
     * getAll paginado dos produtos, talvez receber o orderby e outros
     *
     * @return Retorna a lista de produtos
     */
    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Ação de cadastro de novo produto
     *
     * @param product Os dados do novo produto que será cadastrado
     * @return Retorna os dados do produto agora com o ID
     */
    @PostMapping("/product")
    public Product createProduct(@Validated @RequestBody Product product) {
        return productRepository.save(product);
    }

    /**
     * Ação que retorna os dados de um produto ou uma mensagem de conteúdo
     * não encontrado
     *
     * @param id Id de um produto cadastrado no banco de dados
     * @return Os
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));

        return ResponseEntity.ok().body(product);
    }
}

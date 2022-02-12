package com.marcoswitcel.restfulwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcoswitcel.restfulwebapi.model.ProductMovement;
import com.marcoswitcel.restfulwebapi.repository.ProductMovementRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductMovementController {

    @Autowired
    private ProductMovementRepository productMovementRepository;

    /**
     * Ação que retorna a lista de movimentos cadastrados.
     *
     * @return Retorna a lista de movimentos cadastrados
     */
    @GetMapping("/product-movement")
    public List<ProductMovement> getAllProductMovement() {
        return productMovementRepository.findAll();
    }
}

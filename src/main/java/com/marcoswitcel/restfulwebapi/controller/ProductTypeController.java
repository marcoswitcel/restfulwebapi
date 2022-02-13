package com.marcoswitcel.restfulwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcoswitcel.restfulwebapi.model.ProductType;
import com.marcoswitcel.restfulwebapi.repository.ProductTypeRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductTypeController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    /**
     * Ação que retonar a lista com todos os atores.
     *
     * @return Retorna a lista de produtos
     */
    @GetMapping("/product-type")
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

}

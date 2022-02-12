package com.marcoswitcel.restfulwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Ação de cadastro de o novo movimento de produto.
     *
     * @param productMovement Os dados da nova movimentação de produto que será cadastrada
     * @return Retorna os dados da movimentação de produto agora com o ID caso der sucesso
     */
    @PostMapping("/product-movement")
    public ProductMovement createProductMovement(@Validated @RequestBody ProductMovement productMovement) {
        return productMovementRepository.save(productMovement);
    }

}

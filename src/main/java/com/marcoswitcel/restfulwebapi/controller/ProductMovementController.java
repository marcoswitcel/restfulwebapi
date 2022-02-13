package com.marcoswitcel.restfulwebapi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.marcoswitcel.restfulwebapi.exception.ProductMovementQuantityNotAvailableException;
import com.marcoswitcel.restfulwebapi.exception.ProductNotFoundException;
import com.marcoswitcel.restfulwebapi.model.Product;
import com.marcoswitcel.restfulwebapi.model.ProductMovement;
import com.marcoswitcel.restfulwebapi.repository.ProductRepository;
import com.marcoswitcel.restfulwebapi.repository.ProductMovementRepository;


@RestController
@RequestMapping("/api/v1")
public class ProductMovementController {

    @Autowired
    private ProductMovementRepository productMovementRepository;

    @Autowired
    private ProductRepository productRepository;

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
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ProductMovement createProductMovement(@Validated @RequestBody ProductMovement productMovement) {
        long productId = productMovement.getProduct().getId();

        // Caso o produto não exista, para o processo e retorna um aviso
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        long newQuantityInStock;

        switch (productMovement.getType()) {
            case PURCHASE: {
                newQuantityInStock = product.getQuantityInStock() + productMovement.getQuantity();
            } break;
            case SALE: {
                newQuantityInStock = product.getQuantityInStock() - productMovement.getQuantity();
                // Caso seja uma saída de produto valida se há produtos suficiente para registrar
                if (newQuantityInStock < 0) {
                    throw new ProductMovementQuantityNotAvailableException(product, productMovement.getQuantity());
                }
            } break;
            default: {
                // Caso seja adicionado novos tipos, não avançara até ser revisado aqui
                throw new UnsupportedOperationException(
                    String.format(
                        "Operação não implementada para esse tipo: %s",
                        productMovement.getType().toString()
                    )
                );
            }
        }

        // Atualiza a quantidad do produto e salva
        product.setQuantityInStock(newQuantityInStock);
        productRepository.save(product);

        // Registra o movimento e retorna
        // Por hora a regra de negócio é que toda venda entra com o preço atual do produto
        productMovement.setSellPrice(product.getPrice());
        // Por hora também a data da venda também é sempre igual a data da entrada do pedido nesse ação
        productMovement.setSellDate(
            new Date(
                (new java.util.Date()).getTime()
            )
        );

        return productMovementRepository.save(productMovement);
    }

}

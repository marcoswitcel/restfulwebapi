package com.marcoswitcel.restfulwebapi.exception;

import com.marcoswitcel.restfulwebapi.model.Product;

public class ProductMovementQuantityNotAvailableException extends RuntimeException {

    public ProductMovementQuantityNotAvailableException(Product product, Long requestedQuantity) {
        super(
            String.format(
                "Produto com 'id'=%d e 'quantidade atual'=%d) não possui '%d' unidades para atender à movimentação",
                product.getId(),
                product.getQuantityInStock(),
                requestedQuantity
            )
        );
    }

}

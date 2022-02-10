package com.marcoswitcel.restfulwebapi.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Não pode encontrar o produto com id: " + id);
    }
}

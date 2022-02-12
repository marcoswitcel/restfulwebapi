package com.marcoswitcel.restfulwebapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductMovementQuantityNotAvailableAdvice {

    @ResponseBody
    @ExceptionHandler(ProductMovementQuantityNotAvailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String productMovementQuantityNotAvailableHandler(ProductMovementQuantityNotAvailableException ex) {
        return ex.getMessage();
    }

}

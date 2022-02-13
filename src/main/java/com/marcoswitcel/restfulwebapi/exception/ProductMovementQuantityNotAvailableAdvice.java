package com.marcoswitcel.restfulwebapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductMovementQuantityNotAvailableAdvice {

    @ResponseBody
    @ExceptionHandler(ProductMovementQuantityNotAvailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> productMovementQuantityNotAvailableHandler(ProductMovementQuantityNotAvailableException ex) {
        Map<String, Object> json = new HashMap<>();
        json.put("type", "error");
        json.put("message",  ex.getMessage());

        return ResponseEntity.badRequest().body(json);
    }

}

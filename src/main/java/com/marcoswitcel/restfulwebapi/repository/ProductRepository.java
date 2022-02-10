package com.marcoswitcel.restfulwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcoswitcel.restfulwebapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

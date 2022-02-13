package com.marcoswitcel.restfulwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcoswitcel.restfulwebapi.model.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}

package com.marcoswitcel.restfulwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcoswitcel.restfulwebapi.model.ProductMovement;

@Repository
public interface ProductMovementRepository extends JpaRepository<ProductMovement, Long> {

}

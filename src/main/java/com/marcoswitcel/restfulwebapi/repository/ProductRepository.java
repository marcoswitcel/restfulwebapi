package com.marcoswitcel.restfulwebapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcoswitcel.restfulwebapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Encontra todos os registros com o tipo escolhido.
     *
     * @param productTypeId id do tipo de produto que estamos procurando
     * @param page Configurações de paginação que será usada
     * @return Retorna a lista de produtos que tem o tipo requisitado, com a ordem e tamanho previsto no Pageable
     */
    List<Product> findAllByProductTypeId(long productTypeId, Pageable page);

}

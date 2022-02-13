package com.marcoswitcel.restfulwebapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.marcoswitcel.restfulwebapi.model.Product;
import com.marcoswitcel.restfulwebapi.repository.ProductRepository;
import com.marcoswitcel.restfulwebapi.exception.ProductNotFoundException;


@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Ação que retonar a lista com todos os produtos.
     *
     * @TODO acho que seria interessante deixar essa rota como sendo o
     * getAll paginado dos produtos, talvez receber o orderby e outros
     *
     * @return Retorna a lista de produtos
     */
    @GetMapping("/product")
    public List<Product> getAllProducts(@RequestParam("page") Optional<Integer> pageIndex, @RequestParam("type") Optional<Long> productTypeId) {

        // Retorna todos os dados caso não receba o número da página
        if (pageIndex.isEmpty()) {
            return productRepository.findAll();
        }

        // Se receber o ínice, pagina de 10 em 10
        Pageable page = PageRequest.of(
            (pageIndex.isPresent() ? pageIndex.get() : 0),
            10,
            Sort.by("id").descending()
        );

        if (productTypeId.isPresent()) {
            return productRepository.findAllByProductTypeId(productTypeId.get(), page);
        }

        return productRepository.findAll(page).getContent();
    }

    /**
     * Ação de cadastro de novo produto.
     *
     * @param product Os dados do novo produto que será cadastrado
     * @return Retorna os dados do produto agora com o ID
     */
    @PostMapping("/product")
    public Product createProduct(@Validated @RequestBody Product product) {
        return productRepository.save(product);
    }

    /**
     * Ação que retorna os dados de um produto ou uma mensagem de conteúdo
     * não encontrado.
     *
     * @param id Id de um produto cadastrado no banco de dados
     * @return Retorna os dados do produto encontrado
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));

        return ResponseEntity.ok().body(product);
    }

    /**
     * Ação que permite atualizar os dados de um produto.
     *
     * @param id Id de um produto cadastrado no banco de dados
     * @param productPayload Dados do produto que foram enviados, seguem o formato
     *                       do próprio produto
     * @return Retorna os novos dados associados ao produto
     */
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product productPayload) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setDescription(productPayload.getDescription());
        product.setProductType(productPayload.getProductType());
        product.setPrice(productPayload.getPrice());
        product.setQuantityInStock(productPayload.getQuantityInStock());

        productRepository.save(product);

        return ResponseEntity.ok().body(product);
    }

    /**
     * Ação que permite a deleção de produtos do banco de dados.
     *
     * @param id Id de um produto cadastrado no banco de dados
     */
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException(id);
        }
    }

}

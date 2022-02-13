package com.marcoswitcel.restfulwebapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "description")
    private String description;

    /** @TODO criar a relação aqui */
    @Column(name = "product_type_id")
    private long productType;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity_stock")
    private long quantityInStock;

    @OneToMany(mappedBy = "product")
    private List<ProductMovement> productMovements;

    public Product() {
        super();
    }

    public Product(String description, long productType, double price, long quantityInStock) {
        super();
        this.description = description;
        this.productType = productType;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Product(long id, String description, long productType, double price, long quantityInStock) {
        super();
        this.id = id;
        this.description = description;
        this.productType = productType;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getProductType() {
        return productType;
    }

    public void setProductType(long productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return String.format(
            "Product{id=%d, description='%s', productType=%d, price=%4.3f, quantityInStock=%d}",
            this.getId(),
            this.getDescription(),
            this.getProductType(),
            this.getPrice(),
            this.getQuantityInStock()
        );
    }

}

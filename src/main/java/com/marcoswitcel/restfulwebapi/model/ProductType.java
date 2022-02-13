package com.marcoswitcel.restfulwebapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_types")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productType")
    private List<Product> products;

    public ProductType() {
        super();
    }

    public ProductType(String name) {
        this.name = name;
    }

    public ProductType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
            "ProductType{id=%d, name='%s'}",
            this.id,
            this.name
        );
    }

}

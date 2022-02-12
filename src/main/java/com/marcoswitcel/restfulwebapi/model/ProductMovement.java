package com.marcoswitcel.restfulwebapi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "product_movements")
public class ProductMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "type")
    private int type;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name  = "sell_date")
    private Date sellDate;

    @Column(name  = "quantity")
    private long quantity;

    public ProductMovement() {
        super();
    }

    public ProductMovement(long id, Product product, int type, double sellPrice, Date sellDate, long quantity) {
        super();
        this.id = id;
        this.product = product;
        this.type = type;
        this.sellPrice = sellPrice;
        this.sellDate = sellDate;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

}

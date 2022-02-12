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
}

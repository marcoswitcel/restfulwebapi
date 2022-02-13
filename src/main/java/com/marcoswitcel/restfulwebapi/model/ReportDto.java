package com.marcoswitcel.restfulwebapi.model;

public class ReportDto {

    private Product product;

    private double profitQuantity;

    private long salesQuantity;

    public ReportDto(Product product, double profitQuantity, long salesQuantity) {
        super();
        this.product = product;
        this.profitQuantity = profitQuantity;
        this.salesQuantity = salesQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getProfitQuantity() {
        return profitQuantity;
    }

    public void setProfitQuantity(double profitQuantity) {
        this.profitQuantity = profitQuantity;
    }

    public long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
    
}

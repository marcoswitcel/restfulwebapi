package com.marcoswitcel.restfulwebapi.model;

public class ReportDto {

    private Product product;

    private long profitQuantity;

    private long salesQuantity;

    public ReportDto(Product product, long profitQuantity, long salesQuantity) {
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

    public long getProfitQuantity() {
        return profitQuantity;
    }

    public void setProfitQuantity(long profitQuantity) {
        this.profitQuantity = profitQuantity;
    }

    public long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
    
}

package com.example.demo.models;

import java.math.BigDecimal;

public class PositionOnInvoice {
    private String name;
    private Integer quantity;
    private Integer taxRate;
    private String typeUnit;
    private BigDecimal priceForUnit;


    public PositionOnInvoice() {
    }

    public PositionOnInvoice(String name, Integer quantity, Integer taxRate, String typeUnit, BigDecimal priceForUnit) {
        this.name = name;
        this.quantity = quantity;
        this.taxRate = taxRate;
        this.typeUnit = typeUnit;
        this.priceForUnit = priceForUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public String getTypeUnit() {
        return typeUnit;
    }

    public void setTypeUnit(String typeUnit) {
        this.typeUnit = typeUnit;
    }

    public BigDecimal getPriceForUnit() {
        return priceForUnit;
    }

    public void setPriceForUnit(BigDecimal priceForUnit) {
        this.priceForUnit = priceForUnit;
    }
}

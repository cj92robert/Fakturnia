package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class PositionOnInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer taxRate;
    @NotEmpty
    private String typeUnit;
    @NotNull
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

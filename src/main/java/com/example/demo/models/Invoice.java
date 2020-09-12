package com.example.demo.models;

import java.util.Date;

public class Invoice {

    private String numberOfInvoice;
    private String placeOfCreation;
    private Date dateOfCreation;
    private Date dateOfSale;
    private Customer customer;
    private List<PositionOnInvoice> positionOnInvoiceList;
    private String stateOfPayment;
    private Date dateOfPayment;
    private String wayOfPayment;
    private String accountNumber;
    private String description;

    public Invoice() {
    }

    public Invoice(String numberOfInvoice, String placeOfCreation, Date dateOfCreation, Date dateOfSale, Customer customer, List<PositionOnInvoice> positionOnInvoiceList, String stateOfPayment, Date dateOfPayment, String wayOfPayment, String accountNumber, String description) {
        this.numberOfInvoice = numberOfInvoice;
        this.placeOfCreation = placeOfCreation;
        this.dateOfCreation = dateOfCreation;
        this.dateOfSale = dateOfSale;
        this.customer = customer;
        this.positionOnInvoiceList = positionOnInvoiceList;
        this.stateOfPayment = stateOfPayment;
        this.dateOfPayment = dateOfPayment;
        this.wayOfPayment = wayOfPayment;
        this.accountNumber = accountNumber;
        this.description = description;
    }

    public String getNumberOfInvoice() {
        return numberOfInvoice;
    }

    public void setNumberOfInvoice(String numberOfInvoice) {
        this.numberOfInvoice = numberOfInvoice;
    }

    public String getPlaceOfCreation() {
        return placeOfCreation;
    }

    public void setPlaceOfCreation(String placeOfCreation) {
        this.placeOfCreation = placeOfCreation;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PositionOnInvoice> getPositionOnInvoiceList() {
        return positionOnInvoiceList;
    }

    public void setPositionOnInvoiceList(List<PositionOnInvoice> positionOnInvoiceList) {
        this.positionOnInvoiceList = positionOnInvoiceList;
    }

    public String getStateOfPayment() {
        return stateOfPayment;
    }

    public void setStateOfPayment(String stateOfPayment) {
        this.stateOfPayment = stateOfPayment;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getWayOfPayment() {
        return wayOfPayment;
    }

    public void setWayOfPayment(String wayOfPayment) {
        this.wayOfPayment = wayOfPayment;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

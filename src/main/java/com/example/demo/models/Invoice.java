package com.example.demo.models;

import com.example.demo.models.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String numberOfInvoice;
    @NotEmpty
    private String placeOfCreation;
    @NotEmpty
    private Date dateOfCreation;
    @NotEmpty
    private Date dateOfSale;
    @NotNull
    @ManyToOne
    private Customer customer;
    @NotNull
    @OneToMany
    private List<PositionOnInvoice> positionOnInvoiceList;

    private String statusOfPayment;
    @NotEmpty
    private Date dateOfPayment;
    @NotEmpty
    private String wayOfPayment;
    @NotEmpty
    private String accountNumber;

    private String description;

    @JsonIgnore
    @ManyToOne
    private User user;

    public Invoice() {
    }

    public Invoice(String numberOfInvoice, String placeOfCreation, Date dateOfCreation, Date dateOfSale, Customer customer, List<PositionOnInvoice> positionOnInvoiceList, String statusOfPayment, Date dateOfPayment, String wayOfPayment, String accountNumber, String description) {
        this.numberOfInvoice = numberOfInvoice;
        this.placeOfCreation = placeOfCreation;
        this.dateOfCreation = dateOfCreation;
        this.dateOfSale = dateOfSale;
        this.customer = customer;
        this.positionOnInvoiceList = positionOnInvoiceList;
        this.statusOfPayment = statusOfPayment;
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

    public String getStatusOfPayment() {
        return statusOfPayment;
    }

    public void setStatusOfPayment(String stateOfPayment) {
        this.statusOfPayment = stateOfPayment;
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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != null ? !id.equals(invoice.id) : invoice.id != null) return false;
        if (numberOfInvoice != null ? !numberOfInvoice.equals(invoice.numberOfInvoice) : invoice.numberOfInvoice != null)
            return false;
        if (placeOfCreation != null ? !placeOfCreation.equals(invoice.placeOfCreation) : invoice.placeOfCreation != null)
            return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(invoice.dateOfCreation) : invoice.dateOfCreation != null)
            return false;
        if (dateOfSale != null ? !dateOfSale.equals(invoice.dateOfSale) : invoice.dateOfSale != null) return false;
        if (customer != null ? !customer.equals(invoice.customer) : invoice.customer != null) return false;
        if (positionOnInvoiceList != null ? !positionOnInvoiceList.equals(invoice.positionOnInvoiceList) : invoice.positionOnInvoiceList != null)
            return false;
        if (statusOfPayment != null ? !statusOfPayment.equals(invoice.statusOfPayment) : invoice.statusOfPayment != null)
            return false;
        if (dateOfPayment != null ? !dateOfPayment.equals(invoice.dateOfPayment) : invoice.dateOfPayment != null)
            return false;
        if (wayOfPayment != null ? !wayOfPayment.equals(invoice.wayOfPayment) : invoice.wayOfPayment != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(invoice.accountNumber) : invoice.accountNumber != null)
            return false;
        if (description != null ? !description.equals(invoice.description) : invoice.description != null) return false;
        return user != null ? user.equals(invoice.user) : invoice.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (numberOfInvoice != null ? numberOfInvoice.hashCode() : 0);
        result = 31 * result + (placeOfCreation != null ? placeOfCreation.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (dateOfSale != null ? dateOfSale.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (positionOnInvoiceList != null ? positionOnInvoiceList.hashCode() : 0);
        result = 31 * result + (statusOfPayment != null ? statusOfPayment.hashCode() : 0);
        result = 31 * result + (dateOfPayment != null ? dateOfPayment.hashCode() : 0);
        result = 31 * result + (wayOfPayment != null ? wayOfPayment.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

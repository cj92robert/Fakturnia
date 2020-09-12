package com.example.demo.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortName;
    @NotNull
    private String longName;
    private String phone;
    private String IdCardNumber;
    private String postcode;
    private String city;
    private String adress;
    private String country;
    private long discount;
    private String email;
    private String nip;
    private String regon;
    private String description;
    private String bankAccountNumber;
    private Date createdAt;

    public Customer() {
    }

    public Customer(Long id, String shortName, String longName, String phone, String idCardNumber, String postcode, String city, String adress, String country, long discount, String email, String nip, String regon, String description, String bankAccountNumber) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
        this.phone = phone;
        IdCardNumber = idCardNumber;
        this.postcode = postcode;
        this.city = city;
        this.adress = adress;
        this.country = country;
        this.discount = discount;
        this.email = email;
        this.nip = nip;
        this.regon = regon;
        this.description = description;
        this.bankAccountNumber = bankAccountNumber;
    }

    @PrePersist
    void createdAt() {
        this.createdAt= new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCardNumber() {
        return IdCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        IdCardNumber = idCardNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}

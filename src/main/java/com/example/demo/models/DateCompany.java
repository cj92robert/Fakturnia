package com.example.demo.models;

import javax.persistence.Embeddable;

@Embeddable
public class DateCompany {
    private String name;
    private String nip;
    private String street;
    private String city;
    private String postCode;

    public DateCompany() {
    }

    public DateCompany(String name, String nip, String street, String city, String postCode) {
        this.name = name;
        this.nip = nip;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}

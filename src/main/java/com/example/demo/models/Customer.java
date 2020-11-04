package com.example.demo.models;

import com.example.demo.models.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

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
    private Long discount;
    private String email;
    private String nip;
    private String regon;
    private String description;
    private String bankAccountNumber;
    private Date createdAt;

    @JsonIgnore
    @ManyToOne
    private User user;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (shortName != null ? !shortName.equals(customer.shortName) : customer.shortName != null) return false;
        if (longName != null ? !longName.equals(customer.longName) : customer.longName != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        if (IdCardNumber != null ? !IdCardNumber.equals(customer.IdCardNumber) : customer.IdCardNumber != null)
            return false;
        if (postcode != null ? !postcode.equals(customer.postcode) : customer.postcode != null) return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        if (adress != null ? !adress.equals(customer.adress) : customer.adress != null) return false;
        if (country != null ? !country.equals(customer.country) : customer.country != null) return false;
        if (discount != null ? !discount.equals(customer.discount) : customer.discount != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (nip != null ? !nip.equals(customer.nip) : customer.nip != null) return false;
        if (regon != null ? !regon.equals(customer.regon) : customer.regon != null) return false;
        if (description != null ? !description.equals(customer.description) : customer.description != null)
            return false;
        if (bankAccountNumber != null ? !bankAccountNumber.equals(customer.bankAccountNumber) : customer.bankAccountNumber != null)
            return false;
        if (createdAt != null ? !createdAt.equals(customer.createdAt) : customer.createdAt != null) return false;
        return user != null ? user.equals(customer.user) : customer.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (longName != null ? longName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (IdCardNumber != null ? IdCardNumber.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nip != null ? nip.hashCode() : 0);
        result = 31 * result + (regon != null ? regon.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (bankAccountNumber != null ? bankAccountNumber.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

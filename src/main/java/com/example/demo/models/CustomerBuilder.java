package com.example.demo.models;

public final class CustomerBuilder {
    private Long id;
    private String shortName;
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

    private CustomerBuilder() {
    }

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public CustomerBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public CustomerBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerBuilder withIdCardNumber(String IdCardNumber) {
        this.IdCardNumber = IdCardNumber;
        return this;
    }

    public CustomerBuilder withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public CustomerBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CustomerBuilder withAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public CustomerBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public CustomerBuilder withDiscount(long discount) {
        this.discount = discount;
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder withNip(String nip) {
        this.nip = nip;
        return this;
    }

    public CustomerBuilder withRegon(String regon) {
        this.regon = regon;
        return this;
    }

    public CustomerBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CustomerBuilder withBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setShortName(shortName);
        customer.setLongName(longName);
        customer.setPhone(phone);
        customer.setIdCardNumber(IdCardNumber);
        customer.setPostcode(postcode);
        customer.setCity(city);
        customer.setAdress(adress);
        customer.setCountry(country);
        customer.setDiscount(discount);
        customer.setEmail(email);
        customer.setNip(nip);
        customer.setRegon(regon);
        customer.setDescription(description);
        customer.setBankAccountNumber(bankAccountNumber);
        return customer;
    }
}

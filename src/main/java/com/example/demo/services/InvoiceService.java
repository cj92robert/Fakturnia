package com.example.demo.services;

import com.example.demo.models.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll();

    Invoice getById(Long id);

    Invoice save(Invoice invoice);

    Invoice update(Long id, Invoice invoice);

    Invoice delete(Long id);
}

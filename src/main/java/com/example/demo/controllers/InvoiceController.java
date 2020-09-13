package com.example.demo.controllers;

import com.example.demo.models.Invoice;
import com.example.demo.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice/")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("{id}")
    public Invoice getById(@PathVariable Long id){
        return invoiceService.getById(id);
    }

    @PostMapping
    public Invoice save(@Valid @RequestBody Invoice invoice){
        return invoiceService.save(invoice);
    }
    @PatchMapping("{id}")
    public Invoice update(@PathVariable Long id, @Valid @RequestBody Invoice invoice){
        return invoiceService.update(id,invoice);
    }
    @DeleteMapping("{id}")
    public Invoice delete(@PathVariable Long id){
        return invoiceService.delete(id);
    }

}

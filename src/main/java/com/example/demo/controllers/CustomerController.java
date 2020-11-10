package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    Page<Customer> getAllCustomer(Pageable pageable) {
        return customerService.getAll(pageable);
    }

    @GetMapping("{id}")
    Customer getCustomer(@PathVariable Long id){
        return customerService.getById(id);
    }

    @PostMapping
    Customer saveCustomer(@Valid @RequestBody Customer customer){
        return customerService.save(customer);
    }
    @PatchMapping("{id}")
    Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        return customerService.update(id,customer);
    }
    @DeleteMapping("{id}")
    Customer deleteCustomer(@PathVariable Long id){
        return customerService.delete(id);
    }
}

package com.example.demo.services;

import com.example.demo.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> getAll();

    Customer getById(Long id);

    Customer save(Customer customer);

    Customer update(Long id,Customer customer);

    Customer delete(Long id);
}

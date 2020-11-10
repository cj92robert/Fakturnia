package com.example.demo.services;

import com.example.demo.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {
    Page<Customer> getAll(Pageable pageable);

    Customer getById(Long id);

    Customer save(Customer customer);

    Customer update(Long id,Customer customer);

    Customer delete(Long id);
}

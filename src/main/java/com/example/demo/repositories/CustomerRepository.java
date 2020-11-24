package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT customer FROM Customer customer where customer.user.username = ?1")
    Page<Customer> getAllByUsername(String username, Pageable pageable);

    @Query("SELECT customer FROM Customer customer" +
            " where customer.user.username=?2 AND customer.id=?1")
    Optional<Customer> getByIdAndUsername(Long id, String username);

    Optional<Customer> getTopByNip(String s);

}

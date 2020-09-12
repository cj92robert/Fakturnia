package com.example.demo.repositories;

import com.example.demo.models.PositionOnInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionOnInvoiceRepository extends JpaRepository<PositionOnInvoice,Long> {
}

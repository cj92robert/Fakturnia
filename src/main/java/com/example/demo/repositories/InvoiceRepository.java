package com.example.demo.repositories;

import com.example.demo.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("SELECT invoice FROM Invoice invoice where invoice.user.username =?1")
    List<Invoice> getAllByUsername(String username);

    @Query("SELECT invoice FROM Invoice invoice where invoice.user.username =?2 and invoice.id=?1")
    Optional<Invoice> findByIdAndUsername(Long id,String username);
}

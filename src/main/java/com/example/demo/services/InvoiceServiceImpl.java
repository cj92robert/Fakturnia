package com.example.demo.services;

import com.example.demo.exception.InvoiceNotFound;
import com.example.demo.models.Customer;
import com.example.demo.models.Invoice;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.PositionOnInvoiceRepository;
import com.example.demo.repositories.UserRepository;
import com.google.common.base.Strings;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final UserRepository userRepository;
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final PositionOnInvoiceRepository positionOnInvoiceRepository;

    public InvoiceServiceImpl(UserRepository userRepository, InvoiceRepository invoiceRepository, CustomerRepository customerRepository, PositionOnInvoiceRepository positionOnInvoiceRepository) {
        this.userRepository = userRepository;
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;

        this.positionOnInvoiceRepository = positionOnInvoiceRepository;
    }


    @Override
    public List<Invoice> getAll() {

        return invoiceRepository.getAllByUsername(getUserFromContext());
    }

    @Override
    public Invoice getById(Long id) {
        return invoiceRepository.findByIdAndUsername(id,getUserFromContext())
                .orElseThrow(InvoiceNotFound::new);
    }

    @Transactional
    @Override
    public Invoice save(Invoice invoice) {
        var user = userRepository.findByUsername(getUserFromContext()).orElseThrow();
        invoice.setUser(user);
        var customerOptional = customerRepository.getTopByNip(invoice.getCustomerDate().getNip());
        if (customerOptional.isPresent()) {
            invoice.setCustomer(customerOptional.get());
        } else {
            Customer customer = new Customer();
            customer.setAddress(invoice.getCustomerDate().getStreet());
            customer.setCity(invoice.getCustomerDate().getCity());
            customer.setNip(invoice.getCustomerDate().getNip());
            customerRepository.save(customer);
        }
        positionOnInvoiceRepository.saveAll(invoice.getPositionOnInvoiceList());
        invoice = invoiceRepository.save(invoice);
        user.getInvoiceList().add(invoice);
        return null;
    }

    @Transactional
    @Override
    public Invoice update(Long id, Invoice invoice) {
        var invoiceOld = invoiceRepository
                .findByIdAndUsername(id, getUserFromContext())
                .orElseThrow(InvoiceNotFound::new);

        if (!Strings.isNullOrEmpty(invoice.getNumberOfInvoice()))
            invoiceOld.setNumberOfInvoice(invoice.getNumberOfInvoice());
        if (!Strings.isNullOrEmpty(invoice.getPlaceOfCreation()))
            invoiceOld.setPlaceOfCreation(invoice.getPlaceOfCreation());
        if (invoice.getStatusOfPayment() != null)
            invoiceOld.setStatusOfPayment(invoice.getStatusOfPayment());
        if (invoice.getWayOfPayment() != null)
            invoiceOld.setWayOfPayment(invoice.getWayOfPayment());
        if (!Strings.isNullOrEmpty(invoice.getAccountNumber()))
            invoiceOld.setAccountNumber(invoice.getAccountNumber());
        if (!Strings.isNullOrEmpty(invoice.getDescription()))
            invoiceOld.setDescription(invoice.getDescription());
        if(invoice.getDateOfCreation()!=null)
            invoiceOld.setDateOfCreation(invoice.getDateOfCreation());
        if(invoice.getDateOfSale()!=null)
            invoiceOld.setDateOfSale(invoice.getDateOfSale());
        if(invoice.getDateOfPayment()!=null)
            invoiceOld.setDateOfPayment(invoice.getDateOfPayment());

        return invoiceOld;
    }

    @Override
    public Invoice delete(Long id) {
        var invoice= invoiceRepository
                .findByIdAndUsername(id,getUserFromContext())
                .orElseThrow(InvoiceNotFound::new);
        invoiceRepository.delete(invoice);
        return invoice;
    }

    private String getUserFromContext(){
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        return  (String) authentication.getPrincipal();

    }
}

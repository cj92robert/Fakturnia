package com.example.demo.services;

import com.example.demo.exception.InvoiceNotFound;
import com.example.demo.models.Invoice;
import com.example.demo.models.user.User;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    InvoiceRepository invoiceRepository;

    @Mock
    SecurityContext securityContext;

    @Mock
    Authentication authentication;

    InvoiceService invoiceService;

    @BeforeEach
    void setUp() {
        invoiceService = new InvoiceServiceImpl(userRepository, invoiceRepository);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(authentication.getPrincipal()).thenReturn("rob");
    }

    @Test
    void getAll() {
        //given
        List<Invoice> invoiceList = List.of(new Invoice(), new Invoice(), new Invoice());
        //when
        when(invoiceRepository.getAllByUsername(anyString())).thenReturn(invoiceList);
        //then
        assertThat(invoiceService.getAll()).hasSize(3).containsAll(invoiceList);
    }

    @Test
    void getById() {
        //given
        var invoice = new Invoice();
        //when
        when(invoiceRepository
                .findByIdAndUsername(anyLong(), anyString()))
                .thenReturn(java.util.Optional.of(invoice));
        //then
        assertThat(invoiceService.getById(1L)).isNotNull().isEqualTo(invoice);
    }

    @Test
    void getByIdShouldThrowException() {
        //given

        //when
        when(invoiceRepository
                .findByIdAndUsername(anyLong(), anyString()))
                .thenReturn(java.util.Optional.empty());
        //then
        assertThrows(InvoiceNotFound.class, () -> invoiceService.getById(1L));
    }

    @Test
    void save() {
        //given
        var user = new User();
        user.setInvoiceList(new ArrayList<>());
        var invoice = new Invoice();
        //when
        when(userRepository.findByUsername(anyString())).thenReturn(java.util.Optional.of(user));
        when(invoiceRepository.save(any())).thenAnswer(i -> i.getArgument(0));
        invoiceService.save(invoice);
        //then
        assertThat(user.getInvoiceList()).isNotNull().contains(invoice);
        assertThat(invoice.getUser()).isEqualTo(user);
    }

    @Test
    void updateShouldNotChangeAnyProperties() {
        //give
        var invoice = new Invoice();
        var newInvoice = new Invoice();
        Date date = new Date();
        invoice.setNumberOfInvoice("gfgf");
        invoice.setDescription("test");
        invoice.setDateOfPayment(date);
        invoice.setDateOfSale(date);
        invoice.setDateOfCreation(date);
        invoice.setAccountNumber("test");
        invoice.setWayOfPayment("test");
        invoice.setStatusOfPayment("test");
        invoice.setPlaceOfCreation("test");

        //when
        when(invoiceRepository.findByIdAndUsername(any(), any())).thenReturn(java.util.Optional.of(invoice));
        //then

        assertThat(invoiceService.update(1L, newInvoice)).isEqualTo(invoice);

    }

    @Test
    void updateShouldChangeAllProperties() {
        //give
        var invoice = new Invoice();
        var oldInvoice = new Invoice();
        var blankInvoice = new Invoice();
        Date date = new Date();
        invoice.setNumberOfInvoice("gfgf");
        invoice.setDescription("test");
        invoice.setDateOfPayment(date);
        invoice.setDateOfSale(date);
        invoice.setDateOfCreation(date);
        invoice.setAccountNumber("test");
        invoice.setWayOfPayment("test");
        invoice.setStatusOfPayment("test");
        invoice.setPlaceOfCreation("test");

        //when
        when(invoiceRepository.findByIdAndUsername(any(), any())).thenReturn(java.util.Optional.of(oldInvoice));
        //then

        Invoice actual = invoiceService.update(1L, invoice);
        assertThat(actual).isEqualTo(oldInvoice);
        assertThat(actual).isNotEqualTo(blankInvoice);

    }

    @Test
    void updateShouldThrowException() {
        //given
        //when
        when(invoiceRepository.findByIdAndUsername(any(), any())).thenReturn(Optional.empty());
        //then
        assertThrows(InvoiceNotFound.class, () -> invoiceService.update(1L, new Invoice()));

    }

    @Test
    void delete() {
        //given
        var invoice = new Invoice();
        //when
        when(invoiceRepository.findByIdAndUsername(any(), any())).thenReturn(Optional.of(invoice));
        //then
        assertThat(invoiceService.delete(1L)).isEqualTo(invoice);
    }

    @Test
    void deleteShouldThrowException() {
        //given

        //when
        when(invoiceRepository.findByIdAndUsername(any(), any())).thenReturn(Optional.empty());
        //then
        assertThrows(InvoiceNotFound.class, () -> invoiceService.delete(3L));
    }
}

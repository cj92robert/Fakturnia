package com.example.demo.controllers;

import com.example.demo.models.ErrorResponse;
import com.example.demo.services.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class InvoiceControllerTest {
    InvoiceController invoiceController;

    @MockBean
    InvoiceService invoiceService;

    @BeforeEach
    void setUp() {
        invoiceController = new InvoiceController(invoiceService);
    }


    @Test
    void invoiceNotFoundHandler() {
        var response = new ResponseEntity<>(new ErrorResponse("Invoice not found."), HttpStatus.valueOf(500));

        assertThat(invoiceController.InvoiceNotFoundHandler()).isEqualTo(response);
    }
}

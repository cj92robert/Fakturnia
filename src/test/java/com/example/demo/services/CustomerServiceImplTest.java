package com.example.demo.services;

import com.example.demo.exception.CustomerDoesnotExist;
import com.example.demo.models.Customer;
import com.example.demo.models.user.User;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    SecurityContext securityContext;

    @Mock
    Authentication authentication;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl(userRepository, customerRepository);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(authentication.getPrincipal()).thenReturn("rob");
    }

    @Test
    void shouldReturnAllCustomersBelongThatUser() {
        //given

        var customer = new Customer();
        customer.setId(5L);
        List<Customer> customerList = List.of(new Customer(), new Customer(), customer);
        when(customerRepository.getAllByUsername(any())).thenReturn(customerList);
        //when
        var result = customerService.getAll();
        //then

        assertThat(result)
                .containsAll(customerList)
                .hasSize(customerList.size());
    }

    @Test
    void shouldReturnCustomerWithIdEqualAndBelongToUser() {
        //given
        var customer = new Customer();
        customer.setRegon("fsf");

        when(customerRepository.getByIdAndUsername(any(), any())).thenReturn(java.util.Optional.of(customer));

        //when
        var result = customerService.getById(5L);

        //then
        assertThat(result).isEqualTo(customer);
    }

    @Test
    void shouldThrowExceptionNotFoundCustomer() {
        //given
        when(customerRepository.getByIdAndUsername(any(), any())).thenReturn(Optional.empty());

        //when + then
        assertThrows(CustomerDoesnotExist.class, () -> customerService.getById(4L));
    }

    @Test
    void save() {
        //given
        var user = new User();
        var customer = new Customer();
        var customerList = new ArrayList<Customer>();

        customerList.add(customer);
        user.setCustomerList(customerList);
        customer.setEmail("a@a.pl");

        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        when(customerRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        //when
        var result = customerService.save(customer);
        //then
        assertThat(result).isEqualTo(customer);
    }

    @Disabled
    @Test
    void update() {

    }

    @Test
    void deleteMethodShouldReturnCustomer() {
        //given
        var customer = new Customer();
        customer.setCountry("Poland");
        when(customerRepository.getByIdAndUsername(any(), any())).thenReturn(Optional.of(customer));
        //when
        var result = customerService.delete(5L);

        //then
        assertThat(result).isEqualTo(customer);
    }

    @Test
    void deleteMethodShouldThrowException() {
        //given
        when(customerRepository.getByIdAndUsername(any(), any())).thenReturn(Optional.empty());
        //when

        //then
        assertThrows(CustomerDoesnotExist.class, () -> customerService.delete(3L));
    }
}

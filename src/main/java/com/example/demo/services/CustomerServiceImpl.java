package com.example.demo.services;

import com.example.demo.exception.CustomerDoesnotExist;
import com.example.demo.models.Customer;
import com.example.demo.models.user.User;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.UserRepository;
import com.google.common.base.Strings;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAllByUsername(getUserFromContext());
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository
                .getByIdAndUsername(id, getUserFromContext())
                .orElseThrow(() -> new CustomerDoesnotExist("Customer not found"));
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        User user =userRepository.findByUsername(getUserFromContext()).orElseThrow();
        customer.setUser(user);
        customer.setId(null);
        customer=customerRepository.save(customer);
        user.getCustomerList().add(customer);
        return customer;
    }

    @Transactional
    @Override
    public Customer update(Long id, Customer customer) {

        var customerOld=customerRepository
                .getByIdAndUsername(id,getUserFromContext())
                .orElseThrow(()->new CustomerDoesnotExist("Customer don't exist"));

        if(!Strings.isNullOrEmpty(customer.getShortName()))
            customerOld.setShortName(customer.getShortName());
        if(!Strings.isNullOrEmpty(customer.getLongName()))
            customerOld.setLongName(customer.getLongName());
        if(!Strings.isNullOrEmpty(customer.getPhone()))
            customerOld.setPhone(customer.getPhone());
        if(!Strings.isNullOrEmpty(customer.getPostcode()))
            customerOld.setPostcode(customer.getPostcode());
        if(!Strings.isNullOrEmpty(customer.getCity()))
            customerOld.setCity(customer.getCity());
        if(!Strings.isNullOrEmpty(customer.getAdress()))
            customerOld.setAdress(customer.getAdress());
        if(!Strings.isNullOrEmpty(customer.getCountry()))
            customerOld.setCountry(customer.getCountry());
        if(customer.getDiscount()!=null)
            customerOld.setDiscount(customer.getDiscount());
        if(!Strings.isNullOrEmpty(customer.getEmail()))
            customerOld.setEmail(customer.getEmail());
        if(!Strings.isNullOrEmpty(customer.getNip()))
            customerOld.setNip(customer.getNip());
        if(!Strings.isNullOrEmpty(customer.getRegon()))
            customerOld.setRegon(customer.getRegon());
        if(!Strings.isNullOrEmpty(customer.getDescription()))
            customerOld.setDescription(customer.getDescription());
        if(!Strings.isNullOrEmpty(customer.getBankAccountNumber()))
            customerOld.setBankAccountNumber(customer.getBankAccountNumber());
        if(!Strings.isNullOrEmpty(customer.getIdCardNumber()))
            customerOld.setIdCardNumber(customer.getIdCardNumber());


        return customerOld ;
    }

    @Override
    public Customer delete(Long id) {
        var customer= customerRepository
                .getByIdAndUsername(id,getUserFromContext())
                .orElseThrow(()->new CustomerDoesnotExist("Customer cannot delete because it doesn't find."));
        customerRepository.delete(customer);
        return customer;
    }

    private String getUserFromContext(){
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        return  (String) authentication.getPrincipal();

    }
}

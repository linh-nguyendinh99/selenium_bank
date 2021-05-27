package com.example.bank.service;

import com.example.bank.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer registerCustomer(Customer customer) ;
    List<Customer> getCustomerList();
    Customer declareInformation(Customer customer) ;
    Customer findCustomerByIdentityCode(String identityCode);
}

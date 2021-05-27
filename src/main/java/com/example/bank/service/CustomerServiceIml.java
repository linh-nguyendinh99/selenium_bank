package com.example.bank.service;

import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIml implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomerList() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer declareInformation(Customer customer) {
        return this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer findCustomerByIdentityCode(String identityCode) {
        return this.customerRepository.findByIdentityCode(identityCode);
    }
}

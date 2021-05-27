package com.example.bank.service;

import com.example.bank.IntegrationTest;
import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;
import com.example.bank.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
@Transactional
class CustomerServiceImlTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void registerCustomer() {
        Customer customer = new Customer();
        customer.setName("Đỗ Đức Long");
        customer.setBirthday("2000-09-08");
        customer.setJob("IT");
        customer.setIdentityCode("012414124");
        customer.setSalary("Từ 10 đến 15 triệu");
        Customer savedCus = customerService.registerCustomer(customer);
        assertEquals(savedCus,customer);
    }
}
package com.example.bank.controller;

import com.example.bank.model.Customer;
import com.example.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = "application/json", value = "")
    public ResponseEntity<?> getCustomers(){
        return new ResponseEntity<>(this.customerService.getCustomerList(), HttpStatus.CREATED);
    }

    @PostMapping(produces = "application/json", value = "/registration")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){
        Customer isCustomerExist = customerService.findCustomerByIdentityCode(customer.getIdentityCode());
        if(isCustomerExist != null){
            return new ResponseEntity<>("Identity is exist", HttpStatus.BAD_REQUEST);
        }
        Customer customerAdded = customerService.registerCustomer(customer);

        return new ResponseEntity<>(customerAdded, HttpStatus.CREATED);
    }

    @PutMapping(produces = "application/json", value="/report-information")
    public ResponseEntity<?> reportInformation(@RequestBody Customer customer){
        System.out.println(customer.getPhoneNumber());
        Customer isCustomerExist = customerService.findCustomerByIdentityCode(customer.getIdentityCode());
        customer.setId(isCustomerExist.getId());
        customer.setConfirm(true);
        this.customerService.declareInformation((customer));
        return new ResponseEntity<>("Đăng ký thành công.", HttpStatus.OK);
    }
}

package com.example.bank.controller;

import com.example.bank.model.Customer;
import com.example.bank.model.LoanInformation;
import com.example.bank.model.PayInformation;
import com.example.bank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/loans/{idLoan}/payments")
public class PaymentController {
    @Autowired
    private LoanService loanService;

    @GetMapping(produces = "application/json", value = "")
    public ResponseEntity<?> getLoanByCustomer(@PathVariable int idLoan){
        return new ResponseEntity<>(this.loanService.getPays(idLoan), HttpStatus.OK);
    }

    @PutMapping(produces = "application/json", value = "")
    public ResponseEntity<?> updatePayment(@RequestBody PayInformation payInformation, @PathVariable String idLoan){
        return new ResponseEntity<>(this.loanService.updatePayment(payInformation), HttpStatus.OK);
    }

}


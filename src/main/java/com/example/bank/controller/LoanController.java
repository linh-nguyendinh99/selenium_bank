package com.example.bank.controller;

import com.example.bank.model.Customer;
import com.example.bank.model.LoanInformation;
import com.example.bank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers/{idCustomer}/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping(produces = "application/json", value = "")
    public ResponseEntity<?> saveLoan(@RequestBody LoanInformation loanInformation){
        loanInformation.setLoanPerMonth(Math.round(loanInformation.getLoan()/loanInformation.getNumOfMonths()));
        return new ResponseEntity<>(this.loanService.saveLoan(loanInformation), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json", value = "")
    public ResponseEntity<?> getLoanByCustomer(@PathVariable int idCustomer){
        return new ResponseEntity<>(this.loanService.getLoans(idCustomer), HttpStatus.OK);
    }
}


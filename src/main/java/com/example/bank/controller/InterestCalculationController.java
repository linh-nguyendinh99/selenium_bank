package com.example.bank.controller;

import com.example.bank.model.LoanInformation;
import com.example.bank.model.PayInformation;
import com.example.bank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/calculation")
public class InterestCalculationController {
    @Autowired
    private LoanService loanService;

    @PostMapping(produces = "application/json", value ="/original")
    public ResponseEntity<?> calculationFollowOriginal(@RequestBody LoanInformation loan){
        if(loan.getInterestType() != 2){
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
        loan.setLoanPerMonth(Math.round(loan.getLoan()/loan.getNumOfMonths()));
        return new ResponseEntity<>(this.loanService.calculateLoanByOriginal(loan,1), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json", value="/decreasing")
    public ResponseEntity<?> calculationFollowDecreasing(@RequestBody LoanInformation loan){
        if(loan.getInterestType() != 1){
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
        loan.setLoanPerMonth(Math.round(loan.getLoan()/loan.getNumOfMonths()));
        List<PayInformation> pays = this.loanService.calculateLoanByDecreasing(loan);
        int id=0;
        for (PayInformation pay:pays) {
            pay.setId(id++);
        }
        return new ResponseEntity<>(pays, HttpStatus.OK);
    }
}


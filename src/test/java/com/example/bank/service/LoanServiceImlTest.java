package com.example.bank.service;

import com.example.bank.IntegrationTest;
import com.example.bank.model.LoanInformation;
import com.example.bank.model.PayInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
@Transactional
class CalculateFollowOriginalTest {
    private LoanInformation loanInformation;
    private PayInformation payTest;
    private LocalDate DATE_OF_LOAN_DEFAULT = LocalDate.of(2021, 05, 20);
    private int INTEREST_TYPE_DEFAULT = 2;
    private float INTEREST_RATE_DEFAULT = (float)3.8;
    private int NUM_OF_MONTHS_DEFAULT = 12;
    @Autowired
    private LoanService loanService;

    @BeforeEach
    void setUp() {
        loanInformation = new LoanInformation();
        loanInformation.setDateOfLoan(DATE_OF_LOAN_DEFAULT);
        loanInformation.setInterestType(INTEREST_TYPE_DEFAULT);
        loanInformation.setNumOfMonths(NUM_OF_MONTHS_DEFAULT);
        loanInformation.setInterestRate(INTEREST_RATE_DEFAULT);

        payTest = new PayInformation();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updatePayment() {
        PayInformation payInformation = new PayInformation();
        payInformation.setId(36);
        payInformation.setExistence(1000000);
        LocalDate localDate = LocalDate.of(2021, 07, 18);
        payInformation.setDateOfPay(localDate);
        payInformation.setInterest(9667);
        payInformation.setTotalPerMonth(9667);
        payInformation.setPay(true);
        payInformation.setLoanId(23);
        PayInformation pay = this.loanService.updatePayment(payInformation);
        assertEquals(true, pay.isPay());
    }

    @Test
    void tinhNoConLai() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(0);
        payTest.setPayInformationFollowOriginal(loanInformation);
        assertEquals(10000000, payTest.getExistence());
    }

    @Test
    void tinhNoConLai2(){
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(12);
        payTest.setPayInformationFollowOriginal(loanInformation);
        assertEquals(0, payTest.getExistence());
    }

    @Test
    void tinhNoConLai3() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(13);
        payTest.setPayInformationFollowOriginal(loanInformation);
        assertEquals(0, payTest.getExistence());
    }

    @Test
    void tinhLai() {
        loanInformation.setLoan(10000000);
        loanInformation.setNumOfMonths(12);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/ loanInformation.getNumOfMonths());
        loanInformation.setInterestRate((float) 3.8);
        payTest.setPayInformationFollowOriginal(loanInformation);
        assertEquals(31666, payTest.getInterest());

    }
    @Test
    void failConditionInput1() {
        loanInformation.setLoan(500000);
        fail("Số tiền vay phải lớn hơn 1.000.000");
    }
    @Test
    void failConditionInput2() {
        loanInformation.setLoan((float)(-1));
        fail("Số tiền vay phải lớn hơn 1.000.000");
    }

    @Test
    void failConditionInput3() {
        loanInformation.setNumOfMonths(0);
        fail("Số tháng vay phải lớn hơn 0");
    }

    @Test
    void calTotalPerMonth(){
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setPayInformationFollowOriginal(loanInformation);
        assertEquals(864999, payTest.getTotalPerMonth());
    }

    @Test
    void failCalTotalPerMonthConditionInput1(){
        loanInformation.setLoan(-1);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setPayInformationFollowOriginal(loanInformation);
        fail("Số tiền vay phải lớn hơn 1.000.000");
    }

    @Test
    void failCalTotalPerMonthConditionInput2(){
        loanInformation.setLoan(10000000);
        loanInformation.setNumOfMonths(0);
        fail("Số tháng vay phải lớn hơn 0");
    }


    @Test
    void calculateLoanByDecreasing() {
    }
}
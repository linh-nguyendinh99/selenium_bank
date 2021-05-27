package com.example.bank.service;

import com.example.bank.IntegrationTest;
import com.example.bank.model.LoanInformation;
import com.example.bank.model.PayInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@IntegrationTest
@Transactional
public class CalculateFollowDesTest {
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
    @Test
    void tinhNoConLai() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(0);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(10000000, payTest.getExistence());
    }
    @Test
    void tinhNoConLai2() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(2);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(8333334, payTest.getExistence());
    }

    @Test
    void tinhNoConLai3() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(-1);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        fail("Tháng hiện tại phải lớn hơn 0");
    }

    @Test
    void tinhNoConLai4() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(12);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(0, payTest.getExistence());
    }
    @Test
    void tinhNoConLai5() {
        loanInformation.setLoan(500000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(12);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        fail("Số tiền vay phải lớn hơn 1.000.000");
    }
    @Test
    void tinhNoConLai6() {
        loanInformation.setLoan(100000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(13);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(0, payTest.getExistence());
    }
    @Test
    void tinhLai1() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(0);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(31667, payTest.getInterest());
    }
    @Test
    void tinhLai2() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(1);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(29028, payTest.getInterest());
    }
    @Test
    void tinhLai3() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(11);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(2639, payTest.getInterest());
    }
    @Test
    void tongTienPhaitra1() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(0);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(865000, payTest.getTotalPerMonth());
    }
    @Test
    void tongTienPhaitra2() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(1);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(862361, payTest.getTotalPerMonth());
    }
    @Test
    void tongTienPhaitra3() {
        loanInformation.setLoan(10000000);
        loanInformation.setLoanPerMonth(loanInformation.getLoan()/loanInformation.getNumOfMonths());
        payTest.setCountMonth(11);
        payTest.setPayInformationFollowDecreasing(loanInformation);
        assertEquals(835972, payTest.getTotalPerMonth());
    }
    @Test
    void tongTienPhaitra4() {
        loanInformation.setNumOfMonths(0);
        payTest.setCountMonth(13);
        if(loanInformation.getNumOfMonths() < payTest.getCountMonth()){
            fail("Số tháng vay phải lớn hơn số tháng hiện tại");
        }
    }
}

package com.example.bank.service;

import com.example.bank.model.Customer;
import com.example.bank.model.LoanInformation;
import com.example.bank.model.PayInformation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {
    List<LoanInformation> getLoans(int customerId);
    Boolean checkLoanByPk(int idLoan);
    List<PayInformation> getPays(int loanId);
    Boolean checkPayByPk(int idPay);
    LoanInformation saveLoan(LoanInformation loan);
    PayInformation updatePayment(PayInformation payment);
    PayInformation calculateLoanByOriginal(LoanInformation loan, int countMonth);
    List<PayInformation> calculateLoanByDecreasing(LoanInformation loan);
}

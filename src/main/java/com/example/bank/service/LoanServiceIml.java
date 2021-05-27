package com.example.bank.service;

import com.example.bank.model.*;
import com.example.bank.repository.LoanRepository;
import com.example.bank.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceIml implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private PayRepository payRepository;

    @Override
    public List<LoanInformation> getLoans(int customerId) {
        return this.loanRepository.findLoanInformationsByCustomerId(customerId);
    }

    @Override
    public Boolean checkLoanByPk(int idLoan) {
        Optional<LoanInformation> loan = this.loanRepository.findById(idLoan);
        if(loan != null){
            return false;
        }
        return true;
    }

    @Override
    public List<PayInformation> getPays(int loanId) {
        return this.payRepository.getPayInformationsByLoanId(loanId);
    }

    @Override
    public Boolean checkPayByPk(int idPay) {
        Optional<PayInformation> pay = this.payRepository.findById(idPay);
        if(pay != null){
            return false;
        }
        return true;
    }

    @Override
    public LoanInformation saveLoan(LoanInformation loan) {
        PayInformation payInformation;
        int idCustomer = loan.getCustomerId();
        LoanInformation loanSaved = this.loanRepository.save(loan);
        if(loan.getInterestType()==2){
            for(int i=0; i < loan.getNumOfMonths(); i++){
                payInformation = calculateLoanByOriginal(loanSaved,i+1);
                payInformation.setIdCustomer(idCustomer);
                payInformation.setLoanId(loanSaved.getId());
                System.out.println(payInformation.getLoanPerMonth());
                this.payRepository.save(payInformation);
            }
        }else{
            List<PayInformation> listPay = calculateLoanByDecreasing(loanSaved);
            for (PayInformation pay:listPay) {
                pay.setLoanId(loanSaved.getId());
                pay.setIdCustomer(idCustomer);
            }
            this.payRepository.saveAll(listPay);
        }
        return loanSaved;
    }

    @Override
    public PayInformation updatePayment(PayInformation payment) {

        PayInformation pay = this.payRepository.saveAndFlush(payment);
        return pay;
    }

    @Override
    public PayInformation calculateLoanByOriginal(LoanInformation loan, int countMonth) {
        PayInformation pay = new PayInformation();
        pay.setCountMonth(countMonth);
        pay.setPayInformationFollowOriginal(loan);
        return pay;
    }

    @Override
    public List<PayInformation> calculateLoanByDecreasing(LoanInformation loan) {
        List<PayInformation> listPay = new ArrayList<>();
        for (int i = 0; i<loan.getNumOfMonths(); i++){
            PayInformation pay = new PayInformation();
            pay.setCountMonth(i+1);
            pay.setPayInformationFollowDecreasing(loan);
            listPay.add(pay);
        }
        return listPay;
    }

}
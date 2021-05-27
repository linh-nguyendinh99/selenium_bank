package com.example.bank.repository;
import com.example.bank.model.LoanInformation;
import com.example.bank.model.PayInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRepository extends JpaRepository<PayInformation,Integer> {
    List<PayInformation> getPayInformationsByLoanId(int loanId);
}
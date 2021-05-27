package com.example.bank.repository;
import com.example.bank.model.Customer;
import com.example.bank.model.LoanInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanInformation,Integer> {
    List<LoanInformation> findLoanInformationsByCustomerId(int customerId);
}
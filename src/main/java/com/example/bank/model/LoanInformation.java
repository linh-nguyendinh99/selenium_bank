package com.example.bank.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan_information")
@Entity
@Component
public class LoanInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "loan")
    private float loan;

    @Column(name = "date_of_loan")
    private LocalDate dateOfLoan;

    @Column(name = "interest_rate")
    private float interestRate;

    @Column(name = "interest_type")
    private int interestType;

    @Column(name="loan_per_month")
    private float loanPerMonth;

    @Column(name="num_of_months")
    private int numOfMonths;

    @Column(name="customer_id")
    private int customerId;

    public String toString(){
        return "loan " + this.loan +"\n"
                +"dateOfLoan " + this.dateOfLoan+"\n"
                +"interestRate " + this.interestRate+"\n"
                +"interestType " + this.interestType+"\n"
                +"loanPerMonth " + this.loanPerMonth+"\n"
                +"numOfMonths " +this.numOfMonths+"\n";
    }
}
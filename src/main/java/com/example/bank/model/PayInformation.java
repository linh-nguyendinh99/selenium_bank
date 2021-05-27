package com.example.bank.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pay_information")
@Entity
@Component
public class PayInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "existence")
    protected float existence;

    @Column(name = "date_of_pay")
    protected LocalDate dateOfPay;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name ="interest")
    protected float interest;

    @Column(name="total_per_month")
    protected float totalPerMonth;

    @Column(name= "count_month")
    protected int countMonth;

    @Column(name="is_pay")
    private boolean isPay;

    @Column(name = "customer_id")
    private int idCustomer;

    @Column(name="loan_id")
    private int loanId;

    @Column(name = "loan_per_month")
    private float loanPerMonth;

    public void setPayInformationFollowOriginal(LoanInformation loan){
       this.dateOfPay = loan.getDateOfLoan().plusMonths(this.countMonth);//ngay tra
        this.loanPerMonth = loan.getLoanPerMonth();
        float interestRate = loan.getInterestRate()/100; //lai suat
        float loanPerMonth = loan.getLoanPerMonth();  //no goc phai tra hang thang
        float loanTotal = loan.getLoan(); //no goc

        //tinh lai theo du no ban dau
        this.existence = Math.round(loanTotal-loanPerMonth*this.countMonth); //so no con lai
        this.interest = Math.round(loan.getLoan()*interestRate)/loan.getNumOfMonths(); //tien lai phai tra hang thang
        this.totalPerMonth = Math.round(this.interest+loanPerMonth); // tinh tong tien phai tra hang thang
    }
    public void setPayInformationFollowDecreasing(LoanInformation loan){
        this.dateOfPay = loan.getDateOfLoan().plusMonths(this.countMonth); //ngay tra
        this.loanPerMonth = loan.getLoanPerMonth();
        float interestRate = loan.getInterestRate()/100; //lai suat
        float loanPerMonth = loan.getLoanPerMonth();  //no goc phai tra hang thang
        float loanTotal = loan.getLoan(); //no goc
         //tinh lai theo du no giam dan
        this.existence = Math.round(loanTotal-loanPerMonth*this.countMonth); //so no con lai
        this.interest = Math.round(
                (loan.getLoan()-(loanPerMonth*this.countMonth))*interestRate
                        /loan.getNumOfMonths()); // tien lai phai tra
        this.totalPerMonth = Math.round(this.interest+loanPerMonth); // tinh tong tien phai tra hang thang
    }
}

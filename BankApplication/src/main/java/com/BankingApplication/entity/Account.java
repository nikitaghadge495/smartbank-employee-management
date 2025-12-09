package com.BankingApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Account_Holder_Name")
    private String AccHolderName;
    private double balance;

    public Account(Long id, String AccHolderName, double balance )
    {
       super();
       this.id=id;
       this.AccHolderName=AccHolderName;
       this.balance=balance;
    }
    public Account()
    {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccHolderName() {
        return AccHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        AccHolderName = accHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

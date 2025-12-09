package com.BankingApplication.Dto;

public class AccountDto
{
    private Long id;
    private String AccHolderName;
    private double balance;

    public AccountDto(Long id, String AccHolderName, double balance )
    {
        super();
        this.id=id;
        this.AccHolderName=AccHolderName;
        this.balance=balance;
    }
    public AccountDto()
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
    public void setAccHolderName(String AccHolderName)
    {
        this.AccHolderName=AccHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

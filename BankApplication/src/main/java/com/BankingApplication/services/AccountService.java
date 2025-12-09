package com.BankingApplication.services;

import com.BankingApplication.Dto.AccountDto;
import com.BankingApplication.entity.Account;

import java.util.List;

public interface AccountService
{
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withDraw(Long id, double amount);
    List<AccountDto>getAllAccount();
    void deleteAccount(Long id);
}

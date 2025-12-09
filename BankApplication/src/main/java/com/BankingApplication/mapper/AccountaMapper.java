package com.BankingApplication.mapper;

import com.BankingApplication.Dto.AccountDto;
import com.BankingApplication.entity.Account;

public class AccountaMapper
{
    public static  Account mapToAccount(AccountDto accountDto)//AccountDto kadun jo data yenar to account msdhe taknar
    {
        Account account = new Account(
                accountDto.getId(), accountDto.getAccHolderName(), accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account)//Account kadun jo data yenar to accountDto madhe taknar
    {
        AccountDto accountDto= new AccountDto(
                account.getId(), account.getAccHolderName(), account.getBalance()
        );
        return accountDto;

    }
}

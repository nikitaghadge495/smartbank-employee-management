package com.BankingApplication.services.impl;

import com.BankingApplication.Dto.AccountDto;
import com.BankingApplication.entity.Account;
import com.BankingApplication.mapper.AccountaMapper;
import com.BankingApplication.repository.AccountRepository;
import com.BankingApplication.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceimpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceimpl(AccountRepository accountRepository)//now inject the repository because in repository we decide the the our account entity and type
    {
        super();
        this.accountRepository=accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) //to map the value which is get from the AccountMapper class
    {
        Account account = AccountaMapper.mapToAccount(accountDto);

//        postman or frentend kadun jo data yenar aahe to controller kde aani controller call krnar service chya
//        method which is createaccount....data asnar accountdto chya format madhe so we have to change is into account
//        format accountmapper class cha ue krun to conver krnar account data format madhe

        Account savedAccount = accountRepository.save(account);
        return AccountaMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);  // findById returns Optional<Account>
        Account account = accountOptional.orElseThrow(() ->
                new EntityNotFoundException("Account not found for id: " + id));  // Handle missing account
        return AccountaMapper.mapToAccountDto(account);  // Assuming the mapper class is correctly named
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Optional<Account> accountOptional = accountRepository.findById(id);  // findById returns Optional<Account>
        Account account = accountOptional.orElseThrow(() ->
                new EntityNotFoundException("Account not found for id: " + id));
       double totalBalance = account.getBalance()+amount;
       account.setBalance(totalBalance);
       Account savedAccount=accountRepository.save(account);
       return AccountaMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withDraw(Long id, double amount)
    {
        Optional<Account> accountOptional = accountRepository.findById(id);  // findById returns Optional<Account>
        Account account = accountOptional.orElseThrow(() ->
                new EntityNotFoundException("Account not found for id: " + id));  // Handle missing account

        if(account.getBalance()<amount)
        {
            throw new RuntimeException("Sufficient Amount is not aviable");
        }
        double totalBalance = account.getBalance()-amount;
        account.setBalance(totalBalance);
        Account savedAccount = accountRepository.save(account);
        return AccountaMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount()
    {
       return accountRepository.findAll().stream().map((account) -> AccountaMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);  // findById returns Optional<Account>
        Account account = accountOptional.orElseThrow(() ->
                new EntityNotFoundException("Account not found for id: " + id));  // Handle missing account
        accountRepository.delete(account);
    }
}

package com.BankingApplication.controller;

import com.BankingApplication.Dto.AccountDto;
import com.BankingApplication.services.AccountService;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/accounts")
public class AccountController
{
    private AccountService accountService;

    public AccountController(AccountService accountService)
    {
        super();
        this.accountService=accountService;
    }
    //add account rest api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
         AccountDto accountDto = accountService.getAccountById(id);
         return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id,@RequestBody Map<String,Double> request)
    {
        AccountDto accountDto=accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withDraw")
    public ResponseEntity<AccountDto>withDraw(@PathVariable Long id, @RequestBody Map<String ,Double>request)
    {
       AccountDto accountDto= accountService.withDraw(id,request.get("amount"));
       return  ResponseEntity.ok(accountDto);
    }

    @GetMapping()
    public ResponseEntity<List<AccountDto>>getAllAccount()
    {
       List<AccountDto> accountDto= accountService.getAllAccount();
       return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Delete Successfully");
    }
}

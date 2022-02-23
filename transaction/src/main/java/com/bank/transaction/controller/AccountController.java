package com.bank.transaction.controller;


import com.bank.transaction.request.AccountRequestDto;
import com.bank.transaction.response.AccountResponseDto;
import com.bank.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDto> saveAccount(@RequestBody AccountRequestDto accountRequestDto) throws Exception {
        return new ResponseEntity<>(accountService.saveAccountDetail(accountRequestDto), HttpStatus.CREATED);
    }

    @GetMapping(value  = "/{accountId}" , produces = "application/json")
    public ResponseEntity<AccountResponseDto> getContacts(@PathVariable("accountId") Long accountId) throws Exception {
        return new ResponseEntity<>(accountService.findAccountDetailsById(accountId), HttpStatus.OK);
    }
}

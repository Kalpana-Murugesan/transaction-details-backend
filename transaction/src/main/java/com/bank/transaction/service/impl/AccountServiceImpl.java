package com.bank.transaction.service.impl;

import com.bank.transaction.entity.Account;
import com.bank.transaction.repository.AccountRepo;
import com.bank.transaction.request.AccountRequestDto;
import com.bank.transaction.response.AccountResponseDto;
import com.bank.transaction.service.AccountService;
import com.bank.transaction.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    BankService bankService;

    @Override
    public AccountResponseDto saveAccountDetail(AccountRequestDto accountRequestDto) throws Exception {
        Account account = accountRepo.save(convertDtoToEntity(accountRequestDto));
        return convertEntityToDto(account);
    }

    @Override
    public AccountResponseDto findAccountDetailsById(Long id) throws Exception {
        Optional<Account> account = accountRepo.findById(id);
        if(account.isPresent()) {
            return convertEntityToDto(account.get());
        }
        throw new Exception("Invalid Account id");
    }

    @Override
    public Account findAccountById(Long id) throws Exception {
        Optional<Account> account = accountRepo.findById(id);
        if(account.isPresent()) {
            return account.get();
        }
        throw new Exception("Invalid Account id");
    }

    @Override
    public AccountResponseDto getBankDetail(String accountNumber) throws Exception {
        Account account = accountRepo.findAccountByAccountNumber(accountNumber);
        if(Objects.nonNull(account)){
            return convertEntityToDto(account);
        }
        throw new Exception("Invalid account number");
    }


    private AccountResponseDto convertEntityToDto(Account account) throws Exception {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setAccountId(account.getAccountId());
        accountResponseDto.setAccountName(account.getAccountName());
        accountResponseDto.setAccountNumber(account.getAccountNumber());
        accountResponseDto.setBankDetails(bankService.findBankDetailById(account.getBank().getBankId()));
        return accountResponseDto;
    }

    private Account convertDtoToEntity(AccountRequestDto accountRequestDto) throws Exception {
        Account account = new Account();
        account.setAccountName(accountRequestDto.getAccountName());
        account.setAccountNumber(accountRequestDto.getAccountNumber());
        account.setBank(bankService.findBankById(accountRequestDto.getBankId()));
        return account;
    }
}

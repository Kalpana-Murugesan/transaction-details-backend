package com.bank.transaction.service;

import com.bank.transaction.entity.Account;
import com.bank.transaction.request.AccountRequestDto;
import com.bank.transaction.response.AccountResponseDto;

public interface AccountService {

    AccountResponseDto saveAccountDetail(AccountRequestDto accountRequestDto) throws Exception;
    AccountResponseDto findAccountDetailsById(Long id) throws Exception;
    Account findAccountById(Long id) throws Exception;
    AccountResponseDto getBankDetail(String receiverAccountNumber) throws Exception;
}

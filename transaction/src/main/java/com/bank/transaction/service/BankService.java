package com.bank.transaction.service;

import com.bank.transaction.entity.Bank;
import com.bank.transaction.request.BankRequestDto;
import com.bank.transaction.response.BankResponseDto;

public interface BankService {

    BankResponseDto saveBankDetail(BankRequestDto bankRequestDto);
    BankResponseDto findBankDetailById(Long id) throws Exception;
    Bank findBankById(Long bankId) throws Exception;
}

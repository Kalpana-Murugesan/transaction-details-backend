package com.bank.transaction.service;

import com.bank.transaction.request.TransactionRequestDto;
import com.bank.transaction.response.TransactionResponseDto;

public interface TransactionService {
    TransactionResponseDto saveTransaction(TransactionRequestDto transactionRequestDto) throws Exception;
    TransactionResponseDto findTransactionById(Long id) throws Exception;

}

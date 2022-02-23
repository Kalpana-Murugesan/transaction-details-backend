package com.bank.transaction.service.impl;

import com.bank.transaction.entity.Transaction;
import com.bank.transaction.enums.Status;
import com.bank.transaction.repository.TransactionRepo;
import com.bank.transaction.request.TransactionRequestDto;
import com.bank.transaction.response.AccountResponseDto;
import com.bank.transaction.response.TransactionResponseDto;
import com.bank.transaction.service.AccountService;
import com.bank.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    AccountService accountService;

    @Override
    public TransactionResponseDto saveTransaction(TransactionRequestDto transactionRequestDto) throws Exception {
        Transaction transaction = convertDtoToEntity(transactionRequestDto);
        return convertEntityToDto(transactionRepo.save(transaction));
    }

    @Override
    public TransactionResponseDto findTransactionById(Long id) throws Exception {
       Optional<Transaction> transaction = transactionRepo.findById(id);

        if(transaction.isPresent()) {
            return convertEntityToDto(transaction.get());
        }
        throw new Exception("Invalid Account id");
    }


    private TransactionResponseDto convertEntityToDto(Transaction transaction) throws Exception {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setTransactionId(transaction.getTransactionId());
        transactionResponseDto.setAmount(transaction.getAmount());
        transactionResponseDto.setTransactionTime(transaction.getLocalDateTime());
        transactionResponseDto.setAmount(transaction.getAmount());
        AccountResponseDto senderDetail = accountService.getBankDetail(transaction.getSenderAccountNumber());
        AccountResponseDto receiverDetails = accountService.getBankDetail(transaction.getReceiverAccountNumber());
        transactionResponseDto.setSenderAccountNumber(senderDetail.getAccountNumber());
        transactionResponseDto.setSenderAccountBankName(senderDetail.getBankDetails().getBankName());
        transactionResponseDto.setSenderAccountName(senderDetail.getAccountName());

        transactionResponseDto.setReceiverAccountNumber(receiverDetails.getAccountNumber());
        transactionResponseDto.setReceiverAccountBankName(receiverDetails.getBankDetails().getBankName());
        transactionResponseDto.setReceiverAccountName(receiverDetails.getAccountName());

        transactionResponseDto.setTransactionStatus(transaction.getStatus().toString());
        return transactionResponseDto;
    }

    private Transaction convertDtoToEntity(TransactionRequestDto transactionRequestDto) {
       Transaction transaction = new Transaction();
       transaction.setAmount(transactionRequestDto.getAmount());
       transaction.setStatus(Status.SUCCESS);
       transaction.setLocalDateTime(LocalDateTime.now());
       transaction.setSenderAccountNumber(transactionRequestDto.getSenderAccountNumber());
       transaction.setReceiverAccountNumber(transactionRequestDto.getReceiverAccountNumber());
       return transaction;
    }
}

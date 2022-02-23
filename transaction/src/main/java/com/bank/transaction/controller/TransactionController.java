package com.bank.transaction.controller;
import com.bank.transaction.request.TransactionRequestDto;
import com.bank.transaction.response.TransactionResponseDto;
import com.bank.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponseDto> saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto) throws Exception {
        return new ResponseEntity<>(transactionService.saveTransaction(transactionRequestDto), HttpStatus.CREATED);
    }

    @GetMapping(value  = "/{transactionId}" , produces = "application/json")
    public ResponseEntity<TransactionResponseDto> getTransactionDetail(@PathVariable("transactionId") Long transactionId) throws Exception {
        return new ResponseEntity<>(transactionService.findTransactionById(transactionId), HttpStatus.OK);
    }
}

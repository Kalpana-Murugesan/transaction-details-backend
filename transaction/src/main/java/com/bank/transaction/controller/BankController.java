package com.bank.transaction.controller;

import com.bank.transaction.request.BankRequestDto;
import com.bank.transaction.response.BankResponseDto;
import com.bank.transaction.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @PostMapping
    public ResponseEntity<BankResponseDto> saveBank(@RequestBody BankRequestDto bankRequestDto) throws Exception {
        return new ResponseEntity<>(bankService.saveBankDetail(bankRequestDto), HttpStatus.CREATED);
    }

    @GetMapping(value  = "/{bankId}" , produces = "application/json")
    public ResponseEntity<BankResponseDto> getBankDetail(@PathVariable("bankId") Long BankId) throws Exception {
        return new ResponseEntity<>(bankService.findBankDetailById(BankId), HttpStatus.OK);
    }
}

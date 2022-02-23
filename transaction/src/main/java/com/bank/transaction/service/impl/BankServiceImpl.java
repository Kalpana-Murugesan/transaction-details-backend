package com.bank.transaction.service.impl;

import com.bank.transaction.entity.Bank;
import com.bank.transaction.repository.BankRepo;
import com.bank.transaction.request.BankRequestDto;
import com.bank.transaction.response.BankResponseDto;
import com.bank.transaction.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankRepo bankRepo;


    @Override
    public BankResponseDto saveBankDetail(BankRequestDto bankRequestDto) {
        Bank bank = bankRepo.save(convertDtoToEntity(bankRequestDto));
        return convertEntityToDto(bank);
    }

    @Override
    public BankResponseDto findBankDetailById(Long id) throws Exception {
        Optional<Bank> bank = bankRepo.findById(id);
        if(bank.isPresent()) {
            return convertEntityToDto(bank.get());
        }
        throw new Exception("Invalid Bank id");
    }

    @Override
    public Bank findBankById(Long bankId) throws Exception {
        Optional<Bank> bank = bankRepo.findById(bankId);
        if(bank.isPresent()) {
            return bank.get();
        }
        throw new Exception("Invalid Bank id");
    }

    private BankResponseDto convertEntityToDto(Bank bank) {
         BankResponseDto bankResponseDto = new BankResponseDto();
         bankResponseDto.setBankId(bank.getBankId());
         bankResponseDto.setBankName(bank.getBankName());
         return bankResponseDto;
    }

    private Bank convertDtoToEntity(BankRequestDto bankRequestDto) {
        Bank bank = new Bank();
        bank.setBankName(bankRequestDto.getBankName());
        return bank;
    }
}

package com.bank.transaction.response;

public class AccountResponseDto {
    private Long accountId;
    private String accountNumber;
    private String accountName;
    private BankResponseDto bankDetails;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BankResponseDto getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankResponseDto bankDetails) {
        this.bankDetails = bankDetails;
    }
}

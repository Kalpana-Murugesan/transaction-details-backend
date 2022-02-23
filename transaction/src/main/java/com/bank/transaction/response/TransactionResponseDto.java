package com.bank.transaction.response;

import java.time.LocalDateTime;

public class TransactionResponseDto {
    private Long transactionId;
    private String transactionStatus;
    private Double amount;
    private String senderAccountNumber;
    private String senderAccountName;
    private String senderAccountBankName;

    private String receiverAccountNumber;
    private String receiverAccountName;
    private String receiverAccountBankName;
    private LocalDateTime transactionTime;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getSenderAccountName() {
        return senderAccountName;
    }

    public void setSenderAccountName(String senderAccountName) {
        this.senderAccountName = senderAccountName;
    }

    public String getSenderAccountBankName() {
        return senderAccountBankName;
    }

    public void setSenderAccountBankName(String senderAccountBankName) {
        this.senderAccountBankName = senderAccountBankName;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    public void setReceiverAccountName(String receiverAccountName) {
        this.receiverAccountName = receiverAccountName;
    }

    public String getReceiverAccountBankName() {
        return receiverAccountBankName;
    }

    public void setReceiverAccountBankName(String receiverAccountBankName) {
        this.receiverAccountBankName = receiverAccountBankName;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}

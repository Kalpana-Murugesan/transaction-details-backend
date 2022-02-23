package com.bank.transaction.repository;

import com.bank.transaction.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

  @Query(value = "SELECT * FROM account_details where account_number=?1", nativeQuery = true)
  Account findAccountByAccountNumber(String accountNumber);
}

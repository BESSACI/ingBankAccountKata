package com.ing.kata.service;

import java.math.BigDecimal;
import java.util.List;

import com.ing.kata.entity.Account;
import com.ing.kata.exception.DepositException;
import com.ing.kata.exception.WithdrawException;

public interface BankService {
	
	public void deposit(Account account, BigDecimal amount)
	throws DepositException;
	
	public void withdraw(Account account, BigDecimal amount)
	throws WithdrawException;
	
	public List<String> getOperationHistory(Account account);

}

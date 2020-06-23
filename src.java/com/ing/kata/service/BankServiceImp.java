package com.ing.kata.service;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ing.kata.entity.Account;
import com.ing.kata.entity.Operation;
import com.ing.kata.exception.DepositException;
import com.ing.kata.exception.WithdrawException;
import com.ing.kata.tools.DateTools;
import com.ing.kata.tools.OperationEnum;

public class BankServiceImp implements BankService {

	@Override
	public void deposit(Account account, BigDecimal amount) throws DepositException {
		
		
		if (amount.compareTo(new BigDecimal("0.01")) <= 0.01) {
			throw new DepositException();
		}else {
			Operation operation = new Operation(OperationEnum.DEPOSIT,
					LocalDateTime.now(),amount,account.getBalance());
			BigDecimal newBalance = account.getBalance().add(amount);
			account.setBalance(newBalance);
			account.getOperations().add(operation);
		}
		
		
		
		
	}

	@Override
	public void withdraw(Account account, BigDecimal amount) throws WithdrawException {
		
		Operation operation = new Operation(OperationEnum.WITHDRAW,
				LocalDateTime.now(),amount,account.getBalance());
		BigDecimal newBalance = account.getBalance().subtract(amount);
		if (newBalance.compareTo(new BigDecimal("0")) < 0) {
			throw new WithdrawException();
		}else {
			account.setBalance(newBalance);
			account.getOperations().add(operation);
		}
	}

	@Override
	public List<String> getOperationHistory(Account account) {
		List<String> opeHistory = account.getOperations().stream()
				.map(operation -> "Operation: "+ operation.getOperationType().name() +
						", Date: " + DateTools.fromLocalDateTimeToString(operation.getDate()) +
						", Amount:" + operation.getAmount()).collect(Collectors.toList());
				
		
		return opeHistory;
	}

}

package com.ing.kata.main;

import java.math.BigDecimal;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ing.kata.entity.Account;
import com.ing.kata.entity.Customer;
import com.ing.kata.exception.DepositException;
import com.ing.kata.exception.WithdrawException;
import com.ing.kata.service.BankService;
import com.ing.kata.service.BankServiceImp;

public class MainBank {
	
	
	private static final Logger LOG = LogManager.getLogger(MainBank.class);
	private void doBankOperations(Account account, BankService bankService)  {
		try {
			bankService.deposit(account, new BigDecimal("1554.0"));
			bankService.deposit(account, new BigDecimal("546.0"));
			bankService.deposit(account, new BigDecimal("4.0"));
			bankService.deposit(account, new BigDecimal("0.02"));
		} catch (DepositException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
		
		try {
			bankService.withdraw(account, new BigDecimal("458.3"));
			bankService.withdraw(account, new BigDecimal("482.3"));
			bankService.withdraw(account, new BigDecimal("100089.5"));
		} catch (WithdrawException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		MainBank bank = new MainBank();
		Customer c1 = new Customer(1, "customer1");
		Account ac1 = new Account(1, new BigDecimal("1000.0"), c1);
		BankService bankService = new BankServiceImp();
		bank.doBankOperations(ac1, bankService);
		List<String> accountHistory = bankService.getOperationHistory(ac1);
		accountHistory.forEach(System.out::println);
	}

}

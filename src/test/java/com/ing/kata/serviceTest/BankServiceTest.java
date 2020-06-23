package com.ing.kata.serviceTest;



import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.ing.kata.entity.Account;
import com.ing.kata.entity.Customer;
import com.ing.kata.exception.DepositException;
import com.ing.kata.exception.WithdrawException;
import com.ing.kata.service.BankService;
import com.ing.kata.service.BankServiceImp;
import com.ing.kata.tools.DateTools;
import com.ing.kata.tools.OperationEnum;

public class BankServiceTest {
	


	BankService bankService;

	@Before
	public void init() {
		bankService = new BankServiceImp();
	}

	@Test
	public void depositTest() throws DepositException {
		Customer c1 = new Customer(1, "client1");
		Account ac1 = new Account(1, new BigDecimal("1000.0"), c1);
		bankService.deposit(ac1, new BigDecimal("10.0"));
		assertEquals(ac1.getBalance(), new BigDecimal("1010.0"));
		assertEquals(ac1.getOperations().get(0).getOperationType(), OperationEnum.DEPOSIT);
	}
	


	@Test(expected = DepositException.class)
	public void depositExceptionTest() throws DepositException {
		Customer c1 = new Customer(1, "Customer1");
		Account ac1 = new Account(1, new BigDecimal("1000.0"), c1);
		bankService.deposit(ac1, new BigDecimal("0.001"));
	}


	@Test
	public void WithdrawTest() throws WithdrawException {
		Customer c1 = new Customer(1, "Customer1");
		Account ac1 = new Account(1, new BigDecimal("1000.0"), c1);
		bankService.withdraw(ac1, new BigDecimal("10.0"));
		assertEquals(ac1.getBalance(), new BigDecimal("990.0"));
		assertEquals(ac1.getOperations().get(0).getOperationType(), OperationEnum.WITHDRAW);

	}

	@Test(expected = WithdrawException.class)
	public void withdrawExceptionTest() throws WithdrawException {
		Customer c1 = new Customer(1, "Customer1");
		Account ac1 = new Account(1, new BigDecimal("1000.0"), c1);
		bankService.withdraw(ac1, new BigDecimal("1010.0"));
	}

	@Test
	public void getOperationHistoryTest() throws WithdrawException {
		Customer c1 = new Customer(1, "Customer1");
		Account ac1 = new Account(1, new BigDecimal("1000.0"), c1);
		bankService.withdraw(ac1, new BigDecimal("10.0"));
	
		List<String> operationHistoryExpected = ac1.getOperations().stream()
				.map(operation -> "Operation: "+ operation.getOperationType().name() +
						", Date: " + DateTools.fromLocalDateTimeToString(operation.getDate()) +
						", Amount:" + operation.getAmount()).collect(Collectors.toList());
		List<String> operationHistory = bankService.getOperationHistory(ac1);
		assertEquals(operationHistoryExpected.get(0), operationHistory.get(0));
	}



}

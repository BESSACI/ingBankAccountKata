package com.ing.kata.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ing.kata.tools.OperationEnum;

public class Operation {
	
	private OperationEnum operationType;
	private LocalDateTime date;
	private BigDecimal amount;
	private BigDecimal balance;
	
	public Operation(OperationEnum operationType, LocalDateTime date, BigDecimal amount, BigDecimal balance) {
		super();
		this.operationType = operationType;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	public OperationEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationEnum operationType) {
		this.operationType = operationType;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	
	

}

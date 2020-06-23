package com.ing.kata.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private long id;
	private BigDecimal balance;
	private Customer customer;
	private List<Operation> operations;
	
	
	public Account(long id, BigDecimal balance, Customer customer) {
		super();
		this.id = id;
		this.balance = balance;
		this.customer = customer;
		this.operations = new ArrayList<Operation>();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Operation> getOperations() {
		return operations;
	}



	
	
	
	
	

}

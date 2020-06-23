package com.ing.kata.exception;

public class WithdrawException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public WithdrawException() {
		super("no withdraw authorize because insuffisant solde");
	}
	
//	public WithdrawException(String message) {
//		super(message);
//	}

}

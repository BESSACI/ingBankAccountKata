package com.ing.kata.exception;

public class DepositException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public DepositException() {
		super("no deposit authorize because the amount is not superior to €0.01");
	}
	
//	public DepositException(String message) {
//		super(message);
//	}

}

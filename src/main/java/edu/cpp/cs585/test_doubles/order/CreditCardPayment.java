package edu.cpp.cs585.test_doubles.order;

public class CreditCardPayment implements Payment {

	private String creditCardNumber;
	private String expDate;
	private String securityCode;	
	
	private Object bankCentralClient;
	
	public CreditCardPayment(String creditCardNumber, String expDate, String securityCode) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.expDate = expDate;
		this.securityCode = securityCode;
	}

	public boolean processPayment(float amount) {
		// make a connection to the bank
		// if the card info is valid and the balance is enough
		// return true
		
		// otherwise return false
		return false;
	}

}

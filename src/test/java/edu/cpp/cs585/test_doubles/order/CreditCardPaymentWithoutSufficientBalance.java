package edu.cpp.cs585.test_doubles.order;

public class CreditCardPaymentWithoutSufficientBalance extends CreditCardPayment {

	public CreditCardPaymentWithoutSufficientBalance(String creditCardNumber, String expDate, String securityCode) {
		super(creditCardNumber, expDate, securityCode);
	}

	@Override
	public boolean processPayment(float amount) {		
		return false;
	}
	
}

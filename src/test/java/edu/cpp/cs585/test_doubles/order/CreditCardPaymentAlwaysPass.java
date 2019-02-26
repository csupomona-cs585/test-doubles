package edu.cpp.cs585.test_doubles.order;

public class CreditCardPaymentAlwaysPass extends CreditCardPayment {

	public CreditCardPaymentAlwaysPass(String creditCardNumber, String expDate, String securityCode) {
		super(creditCardNumber, expDate, securityCode);
	}

	@Override
	public boolean processPayment(float amount) {		
		return true;
	}
	
}

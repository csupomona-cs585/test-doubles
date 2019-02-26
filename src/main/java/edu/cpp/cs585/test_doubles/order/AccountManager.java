package edu.cpp.cs585.test_doubles.order;

public class AccountManager {

	private Payment payment; 
	private float balance;	
	
	public boolean makeOrder(Order order) {
		if (getPayment().processPayment(order.getPrice())) {
			setBalance(getBalance() - order.getPrice());
			return true;
		} else {
			System.out.println("Failed to process the payment. Please try again.");
			return false;
		}		
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}

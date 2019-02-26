package edu.cpp.cs585.test_doubles.order;

import org.junit.Assert;
import org.junit.Test;

public class AccountManagerTest {

	@Test
	public void testMakeOrder() {
		AccountManager accountManager = new AccountManager();
		accountManager.setBalance(2000);
		accountManager.setPayment(new CreditCardPaymentAlwaysPass("12321", "11/23", "234"));
		
		Order order1 = new Order("abdsfds", 500);
		boolean response = accountManager.makeOrder(order1);
		Assert.assertTrue(response);
		Assert.assertEquals(2000-500, accountManager.getBalance(), 0);
	}
	
	@Test
	public void testMakeOrderWithInvalidCreditCard() {
		AccountManager accountManager = new AccountManager();
		accountManager.setBalance(2000);
		accountManager.setPayment(new CreditCardPaymentInvalidNumber("12321", "11/23", "234"));
		
		Order order1 = new Order("abdsfds", 500);
		boolean response = accountManager.makeOrder(order1);
		Assert.assertFalse(response);
		Assert.assertEquals(2000, accountManager.getBalance(), 0);
	}
	
	@Test
	public void testMakeOrderWithoutSufficientBalance() {
		AccountManager accountManager = new AccountManager();
		accountManager.setBalance(2000);
		accountManager.setPayment(new CreditCardPaymentWithoutSufficientBalance("12321", "11/23", "234"));
		
		Order order1 = new Order("abdsfds", 500);
		boolean response = accountManager.makeOrder(order1);
		Assert.assertFalse(response);
		Assert.assertEquals(2000, accountManager.getBalance(), 0);
	}
}

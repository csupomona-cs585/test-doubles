package edu.cpp.cs585.test_doubles.order;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

public class AccountManagerTest2 {

	@Test
	public void testMakeOrder() {
		Payment payment = mock(CreditCardPayment.class);
		
		when(payment.processPayment(anyFloat())).thenReturn(true);		
		
		AccountManager accountManager = new AccountManager();
		accountManager.setBalance(2000);
		accountManager.setPayment(payment);
		
		Order order1 = new Order("abdsfds", 500);
		boolean response = accountManager.makeOrder(order1);
		Assert.assertTrue(response);
		Assert.assertEquals(2000-500, accountManager.getBalance(), 0);
		
		verify(payment, times(1)).processPayment(500);
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

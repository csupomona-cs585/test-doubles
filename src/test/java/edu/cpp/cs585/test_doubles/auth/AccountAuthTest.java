package edu.cpp.cs585.test_doubles.auth;

import org.junit.Assert;
import org.junit.Test;

public class AccountAuthTest {

	@Test
	public void testVerifyUsernamePassword() {
		AccountAuth auth = new AccountAuth();
		SpyAuthenticator spyAuthenticator = new SpyAuthenticator();
		auth.setAuthenticator(spyAuthenticator);
		boolean response = auth.verifyUsernamePassword("abc", "123");
		Assert.assertFalse(response);
		Assert.assertEquals(1, spyAuthenticator.getCounterCalled());
		
		response = auth.verifyUsernamePassword("abcde", "12345");
		Assert.assertFalse(response);
		Assert.assertEquals(2, spyAuthenticator.getCounterCalled());
		
		response = auth.verifyUsernamePassword("abcdef", "123456");
		Assert.assertFalse(response);
		Assert.assertEquals(3, spyAuthenticator.getCounterCalled());
		
		try {
			response = auth.verifyUsernamePassword("abcdef", "123456");
			Assert.fail("You are supposed to see an exception for more than 3 login trials. ");
		} catch(RuntimeException e) {
			Assert.assertEquals(4, spyAuthenticator.getCounterCalled());
		}
	}
}

package edu.cpp.cs585.test_doubles.auth;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

public class AccountAuthTest2 {

	@Test
	public void testVerifyUsernamePassword() {
		AccountAuth auth = new AccountAuth();
		IAuthenticator spyAuthenticator = mock(IAuthenticator.class);
		when(spyAuthenticator.login("abc", "123")).thenReturn(false);
		when(spyAuthenticator.login("abcde", "12345")).thenReturn(false);
		when(spyAuthenticator.login("abcdef", "123456")).thenReturn(false);
		
		auth.setAuthenticator(spyAuthenticator);
		boolean response = auth.verifyUsernamePassword("abc", "123");
		Assert.assertFalse(response);
		verify(spyAuthenticator, times(1)).login("abc", "123");
		
		response = auth.verifyUsernamePassword("abcde", "12345");
		Assert.assertFalse(response);
		verify(spyAuthenticator, times(1)).login("abcde", "12345");
		
		response = auth.verifyUsernamePassword("abcdef", "123456");
		Assert.assertFalse(response);
		verify(spyAuthenticator, times(1)).login("abcdef", "123456");
		
		try {
			response = auth.verifyUsernamePassword("abcdef", "123456");
			Assert.fail("You are supposed to see an exception for more than 3 login trials. ");
		} catch(RuntimeException e) {
			verify(spyAuthenticator, times(4)).login(anyString(), anyString());
		}
	}
}

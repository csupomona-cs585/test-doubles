package edu.cpp.cs585.test_doubles.auth;

public class AccountAuth {

	private IAuthenticator authenticator;
	private int counterTrials;
	
	public boolean verifyUsernamePassword(String username, String password) {
		if (username.equals("abc")) {
			return true;
		}
		
		if (getAuthenticator().login(username, password)) {
			return true;
		} else {
			counterTrials++;
			if (counterTrials > 3) {
				throw new RuntimeException("Too many failed logins. Locking your account.");
			}
			return false;
		}
	}

	public IAuthenticator getAuthenticator() {
		return authenticator;
	}

	public void setAuthenticator(IAuthenticator authenticator) {
		this.authenticator = authenticator;
	}
}

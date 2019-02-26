package edu.cpp.cs585.test_doubles.auth;

public class SpyAuthenticator implements IAuthenticator {

	private int counterCalled;
	
	public boolean login(String username, String password) {
		counterCalled++;
		return false;
	}
	
	public int getCounterCalled() {
		return counterCalled;
	}

}

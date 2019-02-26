package edu.cpp.cs585.test_doubles;

import org.junit.Assert;
import org.junit.Test;

public class UserProfileTest {

	@Test
	public void testIsProfileComplete() {
		IImage image = new DummyImage(); //new Image("http://cpp.edu/test.jpg");		
		
		UserProfile userProfile = new UserProfile();
		userProfile.setId("123");
		userProfile.setName("Yu");
		userProfile.setProfileImage(image);
		
		Assert.assertTrue(userProfile.isProfileComplete());
	}
	
	@Test
	public void testIsProfileCompleteWithoutImage() {					
		UserProfile userProfile = new UserProfile();
		userProfile.setId("123");
		userProfile.setName("Yu");
		
		Assert.assertFalse(userProfile.isProfileComplete());
	}
}

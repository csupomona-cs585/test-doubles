package edu.cpp.cs585.test_doubles;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
public class UserProfileTest2 {

	@Test
	public void testIsProfileComplete() {
		IImage image = mock(IImage.class);		
		
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
	
	@Test
	public void testShowUserProfile() {
		IImage mockImage = mock(IImage.class);
//		when(mockImage.getImageByteArray())
//				.thenReturn(new byte[] {1,23,4,5,6});
		UserProfile userProfile = new UserProfile();
		userProfile.setId("123");
		userProfile.setName("Yu");
		userProfile.setProfileImage(mockImage);
		
//		userProfile.showUserProfile();
		
		verify(mockImage).getImageByteArray(); 
	}
}

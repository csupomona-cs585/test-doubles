package edu.cpp.cs585.test_doubles;

public class UserProfile {

	private String name;
	private String id;
	private IImage profileImage;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public IImage getProfileImage() {
		return profileImage;
	}
	
	public void setProfileImage(IImage profileImage) {
		this.profileImage = profileImage;
	}
	
	public boolean isProfileComplete() {
		return name != null && !name.isEmpty() 
				&& id != null && !id.isEmpty()
				&& profileImage != null;
	}
	
	public void showUserProfile() {
		System.out.println("name: " + name);
		System.out.println("id: " + id);
		System.out.println("image: " + profileImage.getImageByteArray().length);
	}
	
}

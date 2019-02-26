package edu.cpp.cs585.test_doubles;

public class Image implements IImage {

	private String url;
	private byte[] imageData;

	public Image(String url) {
		this.url = url;
		// download the image
		System.out.println("Constructor");
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/* (non-Javadoc)
	 * @see edu.cpp.cs585.test_doubles.IImage#getImageByteArray()
	 */
	public byte[] getImageByteArray() {
		return imageData;
	}
	
}

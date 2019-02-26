package edu.cpp.cs585.test_doubles.order;

public class Order {

	private String id;
	private float price;
	
	public Order(String id, float price) {
		super();
		this.id = id;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}

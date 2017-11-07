package com.bean;

public class Book {
    private String id;
    private String name;
    private String auther;
    private double price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String id, String name, String auther, double price) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
	
	
    
}

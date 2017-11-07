package com.bean;

public class CartItem {
    private Book book;
    private int count;
    private double total;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Book book, int count, double total) {
		super();
		this.book = book;
		this.count = count;
		this.total = total;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
		this.total = this.book.getPrice() * this.getCount();
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
    
    
}

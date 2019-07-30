package com.ssafy.work;

public class Magazine extends Book{
	private int year;
	private int month;



	public Magazine(String isbn, String title, String author, String publisher, int price, int year, int month, int quantity) {
		super(isbn, title, author, publisher, price, quantity);
		this.year = year;
		this.month = month;
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month, int quantity) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	@Override
	public String toString() {
		return super.toString() + String.format("|%4d.%2d",year, month);
	}
}

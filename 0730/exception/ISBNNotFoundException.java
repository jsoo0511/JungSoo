package com.ssafy.work.exception;

public class ISBNNotFoundException extends Exception{
	public ISBNNotFoundException(String isbn) {
		super(String.format("%s는 없는 책", isbn));
	}
}

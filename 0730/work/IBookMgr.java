package com.ssafy.work;

import java.util.Collection;

import com.ssafy.work.exception.ISBNNotFoundException;
import com.ssafy.work.exception.QuantityException;

public interface IBookMgr {

	public boolean addBook(Book book);

	public Collection<Book> getBookAll();
	// 동일한 ISBN의 책은 등록될 수 없다.
	public Book getBookByIsbn(String isbn);

	public Collection<Book> getBookByTitle(String title);

	public Collection<Book> getBookOnly();

	public Collection<Book> getMagazine();

	public Collection<Book> getMagazinePublishedThisYear();

	public Collection<Book> getBookByPublisher(String publisher);

	public Collection<Book> getBookLowerPrice(int price);

	public int getSumPrice();

	public double getAvgPrice();

	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;

	public void buy(String isbn, int quantity) throws ISBNNotFoundException;

	public int getTotalAmount();

	public void open();

	public void close();
}

package com.ssafy.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.work.exception.ISBNNotFoundException;
import com.ssafy.work.exception.QuantityException;

public class BookManagerMap implements IBookMgr {
	private Map<String, Book> books =null;
	private final static File file = new File("book_map.dat");

	private static BookManagerMap bml = new BookManagerMap();

	public static BookManagerMap getBm() {
		return bml;
	}

	private BookManagerMap() {
		open();
		if(books==null) {
			books = new HashMap<>();
		}
	}

	@Override
	public boolean addBook(Book book) {
		if (books.containsKey(book.getIsbn())) {
			System.out.println("동일한 책은 들어갈 수 없어요.");
			return false;
		}
		books.put(book.getIsbn(), book);
		return true;
	}

	@Override
	public Collection<Book> getBookAll() {
		return books.values();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Book book = books.get(isbn);
		return book;
	}

	@Override
	public Collection<Book> getBookByTitle(String title) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> bookSet = books.values();
		for (Book book : bookSet) {
			if (book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getBookOnly() {
		List<Book> temp = new ArrayList<>();
		Collection<Book> bookSet = books.values();
		for (Book book : bookSet) {
			if (!(book instanceof Magazine)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getMagazine() {
		List<Book> temp = new ArrayList<>();
		Collection<Book> bookSet = books.values();
		for (Book book : bookSet) {
			if (book instanceof Magazine) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getMagazinePublishedThisYear() {
		List<Book> temp = new ArrayList<>();
		int year = LocalDate.now().getYear();
		Collection<Book> bookSet = books.values();
		for (Book book : bookSet) {
			if (book instanceof Magazine) {
				Magazine m = (Magazine) book;
				if (m.getYear() == year) {
					temp.add(book);
				}
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getBookByPublisher(String publisher) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> bookSet = books.values();
		for (Book book : bookSet) {
			if (book.getPublisher().equals(publisher)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getBookLowerPrice(int price) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> bookSet = books.values();
		for (Book book : bookSet) {
			if (book.getPrice() < price) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public int getSumPrice() {
		int sum = 0;
		Collection<Book> bookSet = books.values();
		for (Book book : bookSet) {
			sum += book.getPrice();
		}
		return sum;
	}

	@Override
	public double getAvgPrice() {
		return 1.0 * getSumPrice() / books.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book book = books.get(isbn);
		if (book == null) {
			throw new ISBNNotFoundException(isbn);
		} else {
			if (book.getQuantity() >= quantity) {
				book.setQuantity(book.getQuantity() - quantity);
			} else {
				throw new QuantityException(quantity, book.getQuantity());
			}
		}
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book book = books.get(isbn);
		if (book == null) {
			throw new ISBNNotFoundException(isbn);
		} else {
			if (book.getIsbn().equals(isbn)) {
				book.setQuantity(book.getQuantity() + quantity);
			}
		}
	}

	@Override
	public int getTotalAmount() {
		int total = 0;
		for (Book book : books.values()) {
			total += book.getPrice() * book.getQuantity();
		}
		return total;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			Object obj = ois.readObject();
			if (obj != null) {
				books = (Map) obj;
			}
			System.out.println("자료 로딩 성공");
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			oos.writeObject(books);
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

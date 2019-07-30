package com.ssafy.work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ssafy.work.exception.ISBNNotFoundException;
import com.ssafy.work.exception.QuantityException;

public class BookManagerList implements IBookMgr {
	private List<Book> books;
	private static BookManagerList bml = new BookManagerList();

	public static BookManagerList getBm() {
		return bml;
	}

	private BookManagerList() {
		// TODO Auto-generated constructor stub
		open();
		if(books==null) {
			books = new ArrayList<>();
		}
	}

	@Override
	public boolean addBook(Book book) {
		for(Book stored: books) {
			if(stored.equals(book)) {
				System.out.println("동일한 책은 들어갈 수 없어요.");
				return false;
			}
		}
		return books.add(book);
	}

	@Override
	public Collection<Book> getBookAll() {
		return books;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Book book = null;
		for (Book temp : books) {
			if (temp.getIsbn().equals(isbn)) {
				book = temp;
			}
		}
		return book;
	}

	@Override
	public Collection<Book> getBookByTitle(String title) {
		List<Book> temp = new ArrayList<>();
		for (Book book : books) {
			if (book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getBookOnly() {
		List<Book> temp = new ArrayList<>();
		for (Book book : books) {
			if (!(book instanceof Magazine)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getMagazine() {
		List<Book> temp = new ArrayList<>();
		for (Book book : books) {
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
		for (Book book : books) {
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
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public Collection<Book> getBookLowerPrice(int price) {
		List<Book> temp = new ArrayList<>();
		for (Book book : books) {
			if (book.getPrice() < price) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public int getSumPrice() {
		int sum = 0;
		for (Book book : books) {
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
		boolean find = false;
		for(Book book: books) {
			if(book.getIsbn().equals(isbn)) {
				find = true;
				if(book.getQuantity()>=quantity) {
					book.setQuantity(book.getQuantity()-quantity);
				}else {
					throw new QuantityException(quantity, book.getQuantity());
				}
				return;
			}
		}
		if(!find) {
			throw new ISBNNotFoundException(isbn);
		}
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		boolean find = false;
		for(Book book: books) {
			if(book.getIsbn().equals(isbn)) {
				find = true;
				book.setQuantity(book.getQuantity() + quantity);
				return;
			}
		}
		if(!find) {
			throw new ISBNNotFoundException(isbn);
		}
	}

	@Override
	public int getTotalAmount() {
		int total = 0;
		for(Book book: books) {
			total+= book.getPrice() * book.getQuantity();
		}
		return total;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book_list.dat"));){
			Object obj = ois.readObject();
			if(obj!=null) {
				books = (List)obj;
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
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book_list.dat"));){
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

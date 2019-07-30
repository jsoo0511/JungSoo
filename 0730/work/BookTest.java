package com.ssafy.work;

import com.ssafy.work.exception.ISBNNotFoundException;
import com.ssafy.work.exception.QuantityException;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IBookMgr bm = BookManagerList.getBm();
		IBookMgr bm = BookManagerMap.getBm();

		Book book0 = new Book("21424", "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본 문법", 10);
		Book book1 = new Book("21424", "JDBC Pro", "김철수", "Jaen.kr", 23000, 10);
		Book book2 = new Book("55355", "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반", 10);
		Book book3 = new Book("35332", "Android App", "홍길동", "Jaen.kr", 25000, "Lightweight Framework", 10);
		Book book4 = new Book("35355", "OOAD 분석, 설계", "소나무", "Jaen.kr", 30000, 10);

		Magazine m0 = new Magazine("35535", "Java World", "편집부", "Java.com", 7000, "", 2013, 2, 10);
		Magazine m1 = new Magazine("33434", "Mobile World", "편집부", "Java.com", 8000, "", 2013, 8, 10);
		Magazine m2 = new Magazine("75342", "Next Web", "편집부", "Java.com", 10000, "AJAX 소개", 2012, 10, 10);
		Magazine m3 = new Magazine("76543", "Architecture", "편집부", "Java.com", 5000, "java 시스템", 2010, 3, 10);
		Magazine m4 = new Magazine("76534", "Data Modeling", "편집부", "Java.com", 14000, "", 2012, 12, 10);

		Magazine m5 = new Magazine("76544", "어차피.", "편집부", "Java.com", 14000, "", 2012, 12, 10);

		Book[] books = { book0, book1, book2, book3, book4, m0, m1, m2, m3, m4, m5 };

		// Book 저장
		System.out.println("도서 저장");
		for (Book book : books) {
			System.out.printf("성공여부: %b %s\n", bm.addBook(book), book);
		}

		// 판매 처리
		try {
			bm.sell("00000", 1);
		} catch (QuantityException e) {
			e.printStackTrace();
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}
		System.out.printf("기본 정보:  %s", bm.getBookByIsbn("55355"));
		try {
			bm.sell("55355", 100);
		} catch (QuantityException e) {
			e.printStackTrace();
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}

		try {
			bm.sell("55355", 5);
		} catch (QuantityException e) {
			e.printStackTrace();
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}
		System.out.printf("판매 후 정보:  %s\n", bm.getBookByIsbn("55355"));

		try {
			bm.buy("55355", 3);
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}
		System.out.printf("구매 후 정보:  %s\n", bm.getBookByIsbn("55355"));
		bm.close();
	}
}

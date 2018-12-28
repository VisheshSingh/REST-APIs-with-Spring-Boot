package org.learn.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BookRepository {

	public static List<Book> BOOKS = new ArrayList<>();
	public static Map<Integer, Book> BOOKMAP = new HashMap<>();
	
	static {
		BOOKS.add(new Book(1001, "Book 1"));
		BOOKS.add(new Book(1002, "Book 2"));
		BOOKS.add(new Book(1003, "Book 3"));
		BOOKS.add(new Book(1004, "Book 4"));
		BOOKS.add(new Book(1005, "Book 5"));
		
		for(Book book: BOOKS) {
			BOOKMAP.put(book.getId(), book);
		}
	}
}

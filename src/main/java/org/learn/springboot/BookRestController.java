package org.learn.springboot;

import java.util.Map;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookRestController {
	
	List<Book> books = BookRepository.BOOKS;
	Map<Integer, Book> BOOKMAP = BookRepository.BOOKMAP;
	
	@GetMapping(value="/books", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Book>> getAllBooks() {
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping(value="/books/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Book> getBook(@PathVariable Integer id) {
		
		Book book = BOOKMAP.get(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/books", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		
		books.add(book);
		BOOKMAP.put(book.getId(), book);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}

package org.learn.springboot;

import java.util.Map;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class BookRestController {
	
	Map<Integer, Book> BOOKMAP = BookRepository.BOOKMAP;
	
	@ApiOperation(value="Returns a collection of Books")
	@GetMapping(value="/books", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Book>> getAllBooks() {
		
		return new ResponseEntity<Collection<Book>>(BOOKMAP.values(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Returns a single book by id")
	@GetMapping(value="/books/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Book> getBook(@PathVariable Integer id) {
		
		Book book = BOOKMAP.get(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		
	}
	
	@ApiOperation(value="Create a new book in collection, returns void")
	@PostMapping(value="/books", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		
		BOOKMAP.put(book.getId(), book);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@ApiOperation(value="Modifies an existing book in collection and return that book")
	@PutMapping(value="/books", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Book> editBook(@RequestBody Book book) {
		
		if(BOOKMAP.containsKey(book.getId())) {
			BOOKMAP.replace(book.getId(), book);
		} else {
			addBook(book);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		
	}
	
	@ApiOperation(value="Deletes a book by id")
	@DeleteMapping(value="/books/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
		
		if(BOOKMAP.containsKey(id)) {
			BOOKMAP.remove(id);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}

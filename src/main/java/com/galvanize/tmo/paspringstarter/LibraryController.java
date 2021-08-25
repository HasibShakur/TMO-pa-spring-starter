package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
	
	// Books will be stored in this data structure
	private static List<Book> booksInLibrary = new ArrayList<>();
	private final AtomicLong index = new AtomicLong();
	
	@GetMapping("/health")
	public void health() {
		
	}
    
	// Add a book to library using HTTP POST
    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public ResponseEntity<Book> addBookToLibrary(@RequestBody Book book)
    {
    	Book newBook = new Book(index.incrementAndGet(), book.getAuthor(), book.getTitle(), book.getYearPublished());
    	booksInLibrary.add(newBook);
    	return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
    }
    
    // Get all the books from library sorted alphabetically
    @RequestMapping("/api/books")
    public ResponseEntity<Object> getBooksInLibrary()
    {
    	List<Book> books = getBooksInAlphabeticOrder();
    	
    	return new ResponseEntity<Object>(books, HttpStatus.OK);
    }
    
    // Delete the books in library
    @RequestMapping(value = "/api/books", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAllBooks()
    {
    	if(!booksInLibrary.isEmpty())
    	{
    		booksInLibrary.removeAll(booksInLibrary);
    	}
    	
    	index.set(0);
    	return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

	private List<Book> getBooksInAlphabeticOrder() {
		Collections.sort(booksInLibrary, new Comparator<Book>() {
			public int compare(Book b1, Book b2)
			{
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		
		List<Book> booksReturned = booksInLibrary;
		return booksReturned;
	}
}


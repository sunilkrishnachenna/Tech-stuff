package com.org.bookstore.controller;


import com.org.bookstore.model.Book;
import com.org.bookstore.model.BookResponse;
import com.org.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // this is responsible for handling request and response
@RequestMapping("api/v1")
public class BookController {

  @Autowired
  private BookService bookService; // object of bs

	/*
	 * @GetMapping("/books") public ResponseEntity<BookResponse> getBooks(){
	 * 
	 * BookResponse books = bookService.getBooks();
	 * 
	 * return books.getListOfBooks().isEmpty() ? new ResponseEntity<>(books,
	 * HttpStatus.NO_CONTENT) : new ResponseEntity<>(books, HttpStatus.OK);
	 */
  //}


	
	  @GetMapping("books/{isbn}") // {} in the path , pathvariable // isbn 3534543
	  public Book getBook(@PathVariable String isbn, @RequestParam String
	  authorName){ //3534543 // RP _. additional parameters
	  
	  Book book = bookService.getBook(isbn, authorName);
	  
	  return book;
	 

  }

  @PostMapping("/books")
  public ResponseEntity<Void> saveBook(@RequestBody Book book) {

    bookService.saveBook(book);

    return new ResponseEntity<>(HttpStatus.CREATED);

  }

  @PutMapping("books/{isbn}") // update , insert  // upsert
  public ResponseEntity<Void> updateBook(@PathVariable String isbn, @RequestParam String authourName) {

    boolean isFound = bookService.updateBook(isbn, authourName);

    return isFound ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("books/{isbn}")
  public void deleteBook(@PathVariable String isbn) {

    bookService.deleteBook(isbn);

  }





}

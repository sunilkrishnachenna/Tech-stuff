package com.org.bookstore.service;



import com.org.bookstore.datasource.BookEntity;
import com.org.bookstore.model.Book;
import com.org.bookstore.model.BookResponse;
import com.org.bookstore.repository.BookRepository;
import com.org.bookstore.repository.BookRepositoryV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BookRepositoryV2 bookRepositoryV2;

  public Book getBook(String isbn, String authorName) {

    // get books list
    List<Book> listOfbooks = bookRepository.booksList();


    // goto every book to find the match
    for(Book book : listOfbooks) { // for each

      if(book.getIsbn().equals(isbn) && book.getAuthour().equals(authorName)) { //3534543

        return book;
      }
    }

    // logic delete, update

    return null;

  }

  public BookResponse getBooks() {

    // get the list of books using repo
//    List<Book> listOfbooks = bookRepository.booksList();
//
//    BookResponse bookResponse = new BookResponse();
//    bookResponse.setListOfBooks(listOfbooks);
//
//    return bookResponse;

    List<BookEntity> listOfBooks = bookRepositoryV2.findAll();

    List<Book> bookList = new ArrayList<>();

    for(BookEntity entity: listOfBooks) {

      Book book = new Book();
      book.setAuthour(entity.getAuthourName());
      book.setIsbn(entity.getIsbn());

      bookList.add(book);

    }
    BookResponse bookResponse = new BookResponse();
    bookResponse.setListOfBooks(bookList);

    return bookResponse;

  }

  public void saveBook(Book book) {

    BookEntity bookEntity = new BookEntity();
    bookEntity.setIsbn(book.getIsbn());
    bookEntity.setAuthourName(book.getAuthour());

    bookRepositoryV2.save(bookEntity);
  }


  public boolean updateBook(String isbn, String authourName) {

    boolean isFound = false ;

    // list of books
    List<Book> listOfBooks = bookRepository.booksList();

    // go through each book and find the matching on
    for(Book book : listOfBooks) {

      if(book.getIsbn().equals(isbn)) {

        isFound = true;
        book.setAuthour(authourName);
        break;

      }

    }

    return isFound;

  }

  public void deleteBook(String isbn) {

    // list of books
    List<Book> listOfBooks = bookRepository.booksList();

    Iterator<Book> iterator = listOfBooks.iterator();

    while (iterator.hasNext()) {

      if((iterator.next().getIsbn()).equals(isbn)){
        iterator.remove();
        break;
      }

    }

  }
}

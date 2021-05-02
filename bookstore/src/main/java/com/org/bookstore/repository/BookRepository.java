package com.org.bookstore.repository;


import com.org.bookstore.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

  List<Book> booksList = new ArrayList<>();

  public List<Book> booksList() {

    return booksList;

  }

  public void saveBook(Book book) {

    booksList.add(book);

  }

}

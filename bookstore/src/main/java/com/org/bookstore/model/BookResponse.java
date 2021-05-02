package com.org.bookstore.model;

import java.util.List;

public class BookResponse {

  private List<Book> listOfBooks;

  public List<Book> getListOfBooks() {
    return listOfBooks;
  }

  public void setListOfBooks(List<Book> listOfBooks) {
    this.listOfBooks = listOfBooks;
  }
}

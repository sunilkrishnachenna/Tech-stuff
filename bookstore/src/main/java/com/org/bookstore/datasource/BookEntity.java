package com.org.bookstore.datasource;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookEntity {

  @Id
  private String isbn;

  private String authourName;

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAuthourName() {
    return authourName;
  }

  public void setAuthourName(String authourName) {
    this.authourName = authourName;
  }
}

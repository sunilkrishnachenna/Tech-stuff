package com.org.bookstore.repository;


import com.org.bookstore.datasource.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryV2 extends JpaRepository<BookEntity, String> {

}

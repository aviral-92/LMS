package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findByBookIdAndStatus(Integer bookId, String status);

	public java.util.List<Book> findByBookNameAndStatus(String bookName, String status);
}

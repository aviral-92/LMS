package com.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	private Integer bookId;

	@Column(name = "BOOK_NAME", nullable = false)
	private String bookName;

	@Column(name = "BOOK_AUTHOR", nullable = false)
	private String bookAuthor;

	@Column(name = "BOOK_COST", nullable = false)
	private double bookCost;

	@Column(name = "STATUS", nullable = false)
	private String status;

	public Book() {
		super();
	}

	public Book(Integer bookId, String bookName, String bookAuthor, double bookCost, String status) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookCost = bookCost;
		this.status = status;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public double getBookCost() {
		return bookCost;
	}

	public void setBookCost(double bookCost) {
		this.bookCost = bookCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

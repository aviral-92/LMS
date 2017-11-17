package com.lms.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

	@Id
	@Column(name = "INVENTORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inventoryId;

	@Column(name = "BK_ID", nullable = false)
	private Integer bkId;

	@Column(name = "BOOK_COUNT", nullable = false)
	private int bookCount;

	@Column(name = "BOOK_ADDED_BY", nullable = false)
	private String addedBy;

	@Column(name = "BOOK_ADDED_DATE", nullable = false)
	private Date addedDate;

	@Column(name = "STATUS", nullable = false)
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BK_ID", referencedColumnName = "BOOK_ID", insertable = false, updatable = false)
	private Book book;

	public Inventory() {
		super();
	}

	public Inventory(Integer inventoryId, Integer bkId, Integer bookCount, String addedBy, Date addedDate,
			String status) {
		super();
		this.inventoryId = inventoryId;
		this.bkId = bkId;
		this.bookCount = bookCount;
		this.addedBy = addedBy;
		this.addedDate = addedDate;
		this.status = status;
	}

	public Inventory(Integer inventoryId, Integer bkId, Integer bookCount, String addedBy, Date addedDate,
			String status, Book book) {
		super();
		this.inventoryId = inventoryId;
		this.bkId = bkId;
		this.bookCount = bookCount;
		this.addedBy = addedBy;
		this.addedDate = addedDate;
		this.status = status;
		this.book = book;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getBkId() {
		return bkId;
	}

	public void setBkId(Integer bkId) {
		this.bkId = bkId;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

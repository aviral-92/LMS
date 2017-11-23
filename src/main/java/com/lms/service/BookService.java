package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lms.entity.Book;
import com.lms.entity.Inventory;
import com.lms.enums.LoginTypeEnum;
import com.lms.repository.BookRepository;
import com.lms.repository.InventoryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private InventoryService inventoryService;

	public String addBook(Book book, LoginTypeEnum loginTypeEnum) {

		String response = "You dont have permission to add user.";
		if (!StringUtils.isEmpty(book) && !StringUtils.isEmpty(loginTypeEnum)) {
			if (loginTypeEnum.equals(LoginTypeEnum.LIBRARIAN)
					|| loginTypeEnum.equals(LoginTypeEnum.ADMIN) && (!isBookExist(book))) {
				try {
					Book books = bookRepository.save(book);
					if (!StringUtils.isEmpty(books)) {

						Inventory inv = inventoryService.addBookInventory(
								inventoryRepository.findByBkId(books.getBookId()), LoginTypeEnum.LIBRARIAN.name());
						if (!StringUtils.isEmpty(inv)) {
							response = "Book added successfully...!!!";
						} else {
							response = "Unable to add book in inventory...";
						}

					} else {
						response = "Book already exist...!!!";
					}
				} catch (Exception e) {
					response = "Book already exist...!!!";
				}
			}
		}
		return response;
	}

	public Book updateBook(Book book) {

		Book books = null;
		if (!StringUtils.isEmpty(book)) {
			books = new Book(book.getBookId(), book.getBookName(), book.getBookAuthor(), book.getBookCost(),
					book.getStatus());
			try {
				Book bk = bookRepository.save(books);
				if (!StringUtils.isEmpty(bk)) {
					return bk;
				}
			} catch (Exception e) {
				System.err.println("Inside catch block in Book");
				return new Book();
			}
		}
		return books;
	}

	private boolean isBookExist(Book book) {

		boolean isExist = false;
		if (!StringUtils.isEmpty(book) && !StringUtils.isEmpty(book.getBookId())) {
			bookRepository.findOne(book.getBookId());
		}
		return isExist;
	}

}

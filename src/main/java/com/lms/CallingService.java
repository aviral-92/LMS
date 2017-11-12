package com.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.entity.Book;
import com.lms.enums.BookTypeEnum;
import com.lms.enums.LoginTypeEnum;
import com.lms.service.BookService;

@Component
public class CallingService {

	

//	@Autowired
//	BookService bookService;

	public void call() {
		Book book = new Book(1, "Complete Java", "Kathy Sierra", 250, BookTypeEnum.AVAILABLE.name());
		BookService service = new BookService();
		String response = service.addBook(book, LoginTypeEnum.LIBRARIAN);
		System.out.println(response);
	}

}

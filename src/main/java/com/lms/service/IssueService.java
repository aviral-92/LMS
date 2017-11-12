package com.lms.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lms.entity.Inventory;
import com.lms.entity.Issue;
import com.lms.enums.IssueTypeEnum;
import com.lms.enums.LoginTypeEnum;
import com.lms.repository.IssueRepository;

@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;
	@Autowired
	private InventoryService inventoryService;

	public String issueBook(Issue issueBook) {

		String response = null;
		if (!StringUtils.isEmpty(issueBook) && inventoryService.isBookAvalableInInventory(issueBook)) {
			issueBook.setStatus(IssueTypeEnum.ISSUED.name());
			issueBook.setIssueDate(new Date());
			Issue issue = issueRepository.save(issueBook);
			if (!StringUtils.isEmpty(issue)) {
				Inventory inventory = inventoryService.bookCountOperation(issue, true);
				if (!StringUtils.isEmpty(inventory)) {
					response = "Book has been issued and your issue id is " + issue.getIssueId();
				} else {
					response = "Not able to issue book ...";
				}
			}
		} else {
			response = "Book not available";
		}
		return response;
	}

	public String returnBook(Issue issueBook, String returnBy) {

		Issue returnBook;
		String response = null;
		if (!StringUtils.isEmpty(issueBook)) {
			returnBook = new Issue();
			returnBook.setIssueId(issueBook.getIssueId());
			returnBook.setStudent_Id(issueBook.getStudent_Id());
			returnBook.setTeacher_Id(issueBook.getTeacher_Id());
			returnBook.setIssueDate(new Date());
			if (returnBy.equals(LoginTypeEnum.LIBRARIAN.name()) || returnBy.equals(LoginTypeEnum.ADMIN.name())) {
				returnBook.setStatus(IssueTypeEnum.RETURNED.name());
			} else {
				returnBook.setStatus(IssueTypeEnum.RETURN_PENDING.name());
			}
			Issue returnBk = issueRepository.save(returnBook);
			if (!StringUtils.isEmpty(returnBk)) {
				Inventory inventory = inventoryService.bookCountOperation(returnBk, false);
				if (!StringUtils.isEmpty(inventory)) {
					response = "Book has been issued and your issue id is " + returnBk.getIssueId();
				} else {
					response = "Not able to issue book ...";
				}
			}
		} else {
			response = "Book not available";
		}
		return response;
	}

}

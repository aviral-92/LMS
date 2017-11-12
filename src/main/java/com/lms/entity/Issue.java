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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ISSUE")
public class Issue {

	@Id
	@Column(name = "ISSUE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer issueId;

	@Column(name = "BK_ID", nullable = false)
	private Integer book_Id;

	@Column(name = "T_ID")
	private Integer teacher_Id;

	@Column(name = "S_ID")
	private Integer student_Id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ISSUE_BOOK_DATE", columnDefinition = "DATETIME", nullable = false)
	private Date issueDate;

	@Column(name = "RETURN_BOOK_DATE")
	private Date returnDate;

	@Column(name = "STATUS", nullable = false)
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BK_ID", referencedColumnName = "BOOK_ID", insertable = false, updatable = false)
	private Book book;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "S_ID", referencedColumnName = "STUDENT_ID", insertable = false, updatable = false)
	private Student student;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "T_ID", referencedColumnName = "TEACHER_ID", insertable = false, updatable = false)
	private Teacher teacher;

	public Issue() {
		super();
	}

	public Issue(Integer issueId, Integer book_Id, Integer teacher_Id, Integer student_Id, Date issueDate,
			Date returnDate, String status, Book book, Student student, Teacher teacher) {
		super();
		this.issueId = issueId;
		this.book_Id = book_Id;
		this.teacher_Id = teacher_Id;
		this.student_Id = student_Id;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.status = status;
		this.book = book;
		this.student = student;
		this.teacher = teacher;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(Integer book_Id) {
		this.book_Id = book_Id;
	}

	public Integer getTeacher_Id() {
		return teacher_Id;
	}

	public void setTeacher_Id(Integer teacher_Id) {
		this.teacher_Id = teacher_Id;
	}

	public Integer getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(Integer student_Id) {
		this.student_Id = student_Id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}

package com.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	@Column(name = "STUDENT_USERNAME", nullable = false)
	private String studentUsername;

	@Column(name = "STUDENT_NAME", nullable = false)
	private String studentName;

	@Column(name = "STUDENT_ADDRESS", nullable = false)
	private String studentAddress;

	@Column(name = "STUDENT_BRANCH", nullable = false)
	private String branch;

	@Column(name = "STATUS", nullable = false)
	private boolean status;

	public Student() {
		super();
	}

	public Student(Integer studentId, String studentName, String studentAddress, String branch, boolean status,
			String studentUsername) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.branch = branch;
		this.status = status;
		this.studentUsername = studentUsername;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentUsername() {
		return studentUsername;
	}

	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

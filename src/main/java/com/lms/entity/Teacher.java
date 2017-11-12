package com.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER")
public class Teacher {

	@Id
	@Column(name = "TEACHER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teacherId;

	@Column(name = "TEACHER_USERNAME", nullable = false)
	private String teacherUsername;

	@Column(name = "TEACHER_NAME", nullable = false)
	private String teacherName;

	@Column(name = "TEACHER_ADDRESS", nullable = false)
	private String teacherAddress;

	@Column(name = "STATUS", nullable = false)
	private boolean status;

	public Teacher() {
		super();
	}

	public Teacher(Integer teacherId, String teacherName, String teacherAddress, boolean status,
			String teacherUsername) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherAddress = teacherAddress;
		this.teacherUsername = teacherUsername;
		this.status = status;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherUsername() {
		return teacherUsername;
	}

	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

package com.lms.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lms.common.service.AbstractService;
import com.lms.entity.Student;

@Service
public class StudentService extends AbstractService {

	@Override
	protected boolean checkUsername(String username) {

		boolean isUsernameExist = false;
		if (!StringUtils.isEmpty(username)) {
			Student student = studentRepository.findByUsername(username);
			if (!StringUtils.isEmpty(student) && !StringUtils.isEmpty(student.getStudentUsername())) {
				isUsernameExist = true;
			}
		}
		return isUsernameExist;
	}

	public String updateStudent(Student student) {

		Student studentTemp = null;
		String response = null;
		if (!StringUtils.isEmpty(student) && !StringUtils.isEmpty(student.getStudentUsername())) {
			studentTemp = new Student(student.getStudentId(), student.getStudentName(), student.getStudentAddress(),
					student.getBranch(), student.isStatus(), student.getStudentUsername());
			try {
				Student stud = studentRepository.save(studentTemp);
				if (!StringUtils.isEmpty(stud)) {
					response = "Student details successfully updated...";
				} else {
					response = "Unable to update it...please provide values.";
				}
			} catch (Exception e) {
				System.err.println("Inside Student Catch...");
				response = "Unable to update it...please provide values.";
			}
		} else {
			response = "Please provide valid username...!!!";
		}
		return response;
	}

}

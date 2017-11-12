package com.lms.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lms.common.service.AbstractService;
import com.lms.entity.Teacher;

@Service
public class TeacherService extends AbstractService {

	@Override
	protected boolean checkUsername(String username) {

		boolean isUsernameExist = false;
		if (!StringUtils.isEmpty(username)) {
			Teacher student = teacherRepository.findByUsername(username);
			if (!StringUtils.isEmpty(student) && !StringUtils.isEmpty(student.getTeacherUsername())) {
				isUsernameExist = true;
			}
		}
		return isUsernameExist;
	}

	public String updateTeacher(Teacher teacher) {

		Teacher teacherTemp = null;
		String response = null;
		if (!StringUtils.isEmpty(teacher) && !StringUtils.isEmpty(teacher.getTeacherUsername())) {
			teacherTemp = new Teacher(teacher.getTeacherId(), teacher.getTeacherName(), teacher.getTeacherAddress(),
					teacher.isStatus(), teacher.getTeacherUsername());
			try {
				Teacher stud = teacherRepository.save(teacherTemp);
				if (!StringUtils.isEmpty(stud)) {
					response = "Teacher details successfully updated...";
				} else {
					response = "Unable to update it...please provide values.";
				}
			} catch (Exception e) {
				System.err.println("Inside Teacher Catch...");
				response = "Unable to update it...please provide values.";
			}
		} else {
			response = "Please provide valid username...!!!";
		}
		return response;
	}
}

package com.lms.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lms.entity.Login;
import com.lms.entity.Student;
import com.lms.entity.Teacher;
import com.lms.enums.LoginTypeEnum;
import com.lms.repository.LoginRepository;
import com.lms.repository.StudentRepository;
import com.lms.repository.TeacherRepository;

@Service
public abstract class AbstractService {

	@Autowired
	protected LoginRepository loginRepository;

	@Autowired
	protected StudentRepository studentRepository;

	@Autowired
	protected TeacherRepository teacherRepository;

	public String addUserByAdmin(Login login) {

		String response = "You dont have permission to add user, you are not ADMIN.";
		if (login.getLoginType().equalsIgnoreCase(LoginTypeEnum.ADMIN.name()) && !checkUsername(login.getUsername())) {
			Login login2 = loginRepository.save(login);
			if (!StringUtils.isEmpty(login2)) {
				response = "User successfully added";
			}
		} else {
			response = "User already exist";
		}
		return response;
	}

	public String addStudent(Student student, LoginTypeEnum loginTypeEnum) {

		String response = "You dont have permission to add user.";
		if (!StringUtils.isEmpty(student) && !StringUtils.isEmpty(loginTypeEnum)) {
			if (loginTypeEnum.equals(LoginTypeEnum.LIBRARIAN)
					|| loginTypeEnum.equals(LoginTypeEnum.ADMIN) && (!checkUsername(student.getStudentUsername()))) {
				Student stud = studentRepository.save(student);
				if (!StringUtils.isEmpty(stud)) {
					response = "Student added successfully...!!!";
				}
			}
		}
		return response;
	}

	public String addTeacher(Teacher teacher, LoginTypeEnum loginTypeEnum) {

		String response = "You dont have permission to add user.";
		if (!StringUtils.isEmpty(teacher) && !StringUtils.isEmpty(loginTypeEnum)) {
			if (loginTypeEnum.equals(LoginTypeEnum.LIBRARIAN)
					|| loginTypeEnum.equals(LoginTypeEnum.ADMIN) && (!checkUsername(teacher.getTeacherUsername()))) {
				Teacher teacher1 = teacherRepository.save(teacher);
				if (!StringUtils.isEmpty(teacher1)) {
					response = "Teacher added successfully...!!!";
				}
			}
		}
		return response;
	}

	protected abstract boolean checkUsername(String username);

}

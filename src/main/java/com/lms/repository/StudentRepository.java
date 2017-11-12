package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByStudentIdAndStudentAddress(Integer studentId, String address);
	
	public Student findByUsername(String username);
}

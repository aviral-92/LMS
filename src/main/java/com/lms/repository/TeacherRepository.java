package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

	public Teacher findByUsername(String username);

}

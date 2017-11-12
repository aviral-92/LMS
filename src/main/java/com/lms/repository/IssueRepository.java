package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.entity.Issue;

public interface IssueRepository extends CrudRepository<Issue, Integer> {

	public java.util.List<Issue> findByStudent_Id(Integer studentId);

	public java.util.List<Issue> findByTeacher_Id(Integer teacherId);
}

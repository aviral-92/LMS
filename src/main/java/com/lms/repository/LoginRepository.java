package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.entity.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

	public Login findByUsername(String username);

	public Login findByUsernameAndPasswordAndLoginTypeAndStatus(String username, String password, String loginType,
			boolean status);
}

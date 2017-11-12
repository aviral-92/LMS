package com.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN")
public final class Login {

	@Id
	@Column(name = "LOGIN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginId;

	@Column(name = "USERNAME", unique = true)
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "LOGIN_TYPE")
	private String loginType;

	@Column(name = "STATUS")
	private boolean status;

	public Login() {
		super();
	}

	public Login(String username, String password, String loginType, boolean status) {
		super();
		this.username = username;
		this.password = password;
		this.loginType = loginType;
		this.status = status;
	}

	public Login(Integer loginId, String username, String password, String loginType, boolean status) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
		this.loginType = loginType;
		this.status = status;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", username=" + username + ", password=" + password + ", loginType="
				+ loginType + ", status=" + status + "]";
	}

}

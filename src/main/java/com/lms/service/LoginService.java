package com.lms.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lms.common.service.AbstractService;
import com.lms.entity.Login;
import com.lms.enums.LoginTypeEnum;

@Service
public class LoginService extends AbstractService {

	public String loginAs(Login login) {

		String response = LoginTypeEnum.NOT_AUTHORISED.name();
		Login loginObj = loginCheck(login);
		if (!StringUtils.isEmpty(loginObj) && !StringUtils.isEmpty(loginObj.getLoginType())) {
			response = loginObj.getLoginType();
		}
		return response;
	}

	private Login loginCheck(Login login) {

		Login loginObj = null;
		if (!StringUtils.isEmpty(login)) {
			loginObj = loginRepository.findByUsernameAndPasswordAndLoginTypeAndStatus(login.getUsername(),
					login.getPassword(), login.getLoginType(), login.isStatus());
			if (!StringUtils.isEmpty(loginObj)) {
				loginObj.setPassword(null);
				System.out.println("Successfully logged in...");
			}
		}
		return loginObj;
	}

	@Override
	protected boolean checkUsername(String username) {

		boolean isUsernameExist = false;
		if (!StringUtils.isEmpty(username)) {
			Login login2 = loginRepository.findByUsername(username);
			if (!StringUtils.isEmpty(login2) && !StringUtils.isEmpty(login2.getUsername())) {
				isUsernameExist = true;
			}
		}
		return isUsernameExist;
	}

}

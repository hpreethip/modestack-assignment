package com.modestack.dao;

import org.springframework.http.ResponseEntity;

import com.modestack.handler.ResponseData;
import com.modestack.model.User;
import com.modestack.model.UserAuth;

public interface UserDao
{
	ResponseEntity<UserAuth> userLogin(User user) throws Exception;

	ResponseEntity<ResponseData> userRegister(User user);
}
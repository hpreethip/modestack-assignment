package com.modestack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modestack.dao.UserDao;
import com.modestack.handler.ResponseData;
import com.modestack.model.User;
import com.modestack.model.UserAuth;

@RestController
public class UserController
{
	@Autowired
	UserDao userDao;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public ResponseEntity<UserAuth> userLogin(@RequestBody User user) throws Exception
	{
		return userDao.userLogin(user);
	}
		
	@CrossOrigin(origins = "*")
	@PostMapping("/register")
	public ResponseEntity<ResponseData> userRegister(@RequestBody User user)
	{
		return userDao.userRegister(user);
	}
}
package com.modestack.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User
{
	@Id
	private String username;
	private String password;
	private String email;
	private String address;
}
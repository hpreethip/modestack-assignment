package com.modestack.model;

import lombok.Data;

@Data
public class UserAuth
{
	private String message;
	private String accessToken;
	
	public UserAuth(String message, String accessToken)
	{
		this.message = message;
		this.accessToken = accessToken;
	}
}
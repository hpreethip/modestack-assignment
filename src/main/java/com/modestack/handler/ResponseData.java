package com.modestack.handler;

import lombok.Data;

@Data
public class ResponseData
{
	private String message;
	
	public ResponseData(String msg)
	{
		this.message = msg;
	}
}
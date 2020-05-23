package com.modestack.handler;

import lombok.Data;

@Data
public class ApiResponseBody
{
	private String statusCode;
	private Object data;

	public ApiResponseBody(final String statusCode)
	{ 
		this.statusCode = statusCode;
	}
}
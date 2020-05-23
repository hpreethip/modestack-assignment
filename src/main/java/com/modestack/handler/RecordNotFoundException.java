package com.modestack.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -8361351864681844951L;

	public RecordNotFoundException(String message)
	{
		super(message);
	}
}
package com.evenugo.exceptions;

import com.evenugo.dao.exceptions.BusinessException;

public class ServiceException extends BusinessException {
    

	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		this(message,null);		
	}
	

	public ServiceException(Throwable cause) {
		this(null,cause);		
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message,cause);		
	}
}
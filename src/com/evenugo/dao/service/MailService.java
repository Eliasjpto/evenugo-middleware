package com.evenugo.dao.service;

import com.evenugo.exceptions.MailException;

public interface MailService {
	public void sendMail(String subject, String message, String... to)
			throws MailException;
}

package com.evenugo.service.impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.evenugo.config.ConfigurationManager;
import com.evenugo.service.MailService;
import com.evenugo.exceptions.MailException;

/**
 * @author usuario
 *
 */
public class MailServiceImpl implements MailService {

//	private static final String CFG_PFX = "service.mail."; 
//	private static final String HOSTNAME_PARAMETER_NAME = CFG_PFX + "host.name";
//	private static final String SMTP_PORT_PARAMETER_NAME  = CFG_PFX + "smtp.port"; 
//	private static final String DEFAULT_USER_NAME =  CFG_PFX + "default.user.name";
//	private static final String DEFAULT_USER_PASSWORD = CFG_PFX + "default.user.password";
//	private static final String DEFAULT_FROM = CFG_PFX + "default.from";

	public MailServiceImpl() {		
	}


	public void sendMail(String subject, String message, String... to) throws MailException{
//
//		ConfigurationManager cfg = ConfigurationManager.getInstance();

		SimpleEmail email = new SimpleEmail();
		try {


			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("jpsmra2018@gmail.com","abc123.,"));
			email.setSSLOnConnect(true);
			email.setFrom("jpsmra2018@gmail.com");			
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			// TODO: Logger
			throw new MailException ("Trying to send email "
					+ " from " 
					+ " using hostname "
					+ " to " + to, e);

		}
	}
}

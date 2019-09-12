package com.metacube.springIOC.Services;

import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender implements MailSender {

	@Override
	public String send(){
		return "Smtp Mail Sender";
	}
}

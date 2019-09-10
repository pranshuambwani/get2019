package com.metacube.springIOC.Services;

import org.springframework.stereotype.Component;

@Component
public class MockMailSender implements MailSender {

	@Override
	public String send() {
		return "Mock Mail Sender";
	}
}

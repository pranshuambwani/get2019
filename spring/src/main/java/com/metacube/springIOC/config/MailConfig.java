package com.metacube.springIOC.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.springIOC.Services.MailSender;
import com.metacube.springIOC.Services.MockMailSender;
import com.metacube.springIOC.Services.SmtpMailSender;

@Configuration
public class MailConfig {

	@Primary
	@Bean
	public MailSender smtpmail() {
		return new SmtpMailSender();
	}

	@Bean
	@Qualifier("mock")
	public MailSender mockmail() {

		return new MockMailSender();

	}
}

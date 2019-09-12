package com.metacube.springIOC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.springIOC.Services.MailSender;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	@Qualifier("mock")
	public MailSender mail;

	
	@Autowired
	// setter/  injection 
	public void setMailSender(@Qualifier("smtpMailSender")MailSender mailSender) {
		this.mail = mailSender;
	}
	
	 
	 // for constructor dependency 
	 @Autowired 
	 public MailController(@Qualifier("mockMailSender")MailSender mailSender) {
		 this.mail = mailSender;

	}

	@GetMapping
	public String getMail() {
		return mail.send();
	}

}


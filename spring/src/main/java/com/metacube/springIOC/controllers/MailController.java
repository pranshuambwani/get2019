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
	public MailSender mail;
	
	@Primary
	@Autowired
	private MailSender mail;
	
	@GetMapping
	public String getmail(){
		return mail.send();
	}
	
	@Autowired
	public void setmail(MailSender mail){
		this.mail=mail;
	}
}

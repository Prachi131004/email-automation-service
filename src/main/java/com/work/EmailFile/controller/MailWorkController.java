package com.work.EmailFile.controller;

import java.util.Map;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.EmailFile.dto.RequestWork;
import com.work.EmailFile.service.EmailService;

@RestController
public class MailWorkController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping(value = "/send", consumes = {"multipart/form-data"})
	public ResponseEntity<Map<String, String>> sendMail(@Valid @ModelAttribute RequestWork request) {
		
		emailService.sendHtmlWithAttachment(
			request.toEmail(), 
			request.subject(), 
			request.body(), 
			request.file()
		);
		
		return ResponseEntity.ok(Map.of("message", "Email is being processed and sent!"));
	}
}
package com.work.EmailFile.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${FROM_EMAIL:username}") 
	private String fromEmail;
	
	@Async
	public void sendHtmlWithAttachment(String toEmail, String sub, String htmlBody, MultipartFile file) { 
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			
			// The 'true' flag here indicates it is a multipart message (supports attachments)
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			
			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(sub);
			
			// The second parameter 'true' tells Spring to render the text as HTML
			helper.setText(htmlBody, true);
			
			// Add the attachment if a file was actually uploaded
			if (file != null && !file.isEmpty()) {
				helper.addAttachment(file.getOriginalFilename(), file);
			}
			
			mailSender.send(mimeMessage);
			System.out.println("HTML Email with attachment sent successfully to: " + toEmail);
			
		} catch (MessagingException e) {
			// Handle email formatting exceptions
			System.err.println("Failed to send email due to messaging error: " + e.getMessage());
		}
	}
}
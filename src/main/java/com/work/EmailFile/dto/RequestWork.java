package com.work.EmailFile.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestWork(
		
		@NotBlank(message = "Recipient email is required")
	    @Email(message = "Invalid email format")
	    String toEmail, 
	    
	    @NotBlank(message = "Subject is required")
	    String subject, 
	    
	    @NotBlank(message = "Body is required")
	    String body, // This can now contain HTML strings like "<h1>Hello</h1>"
	    
	    MultipartFile file // Captures the uploaded attachment file
	    ) {

}

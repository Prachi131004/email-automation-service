package com.work.EmailFile.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.work.EmailFile.service.EmailService;

@Component
public class EmailScheduler {
	
	@Autowired
	private EmailService emailService;

	// This cron expression fires every single day at exactly 4:00:00 PM (16:00)
		@Scheduled(cron = "0 0 16 * * *")
		public void sendEveryDayAtFourPM() {
			String recipient = "thv6873@gmail.com"; 
			String subject = "Evening Wrap-Up Report 🌆";
			String htmlBody = """
				<div style='font-family: Arial, sans-serif; max-width: 450px; padding: 20px; border: 1px solid #ff4757; border-radius: 12px; background-color: #ffffff;'>
					<h3 style='color: #ff4757; margin-top: 0;'>Good Evening! 🌅</h3>
					<p style='color: #57606f;'>This is your automated end-of-day report sent precisely at <b>4:00 PM</b> via Spring Boot Cron scheduling.</p>
					<span style='font-size: 11px; color: #a4b0be;'>Cron pattern used: "0 0 16 * * *"</span>
				</div>
				""";

			emailService.sendHtmlWithAttachment(recipient, subject, htmlBody, null);
			System.out.println("4 PM Cron triggered! Daily evening email dispatched successfully.");
		}
}

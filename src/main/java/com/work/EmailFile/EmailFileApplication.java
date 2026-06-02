package com.work.EmailFile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling 
public class EmailFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailFileApplication.class, args);
	}

}

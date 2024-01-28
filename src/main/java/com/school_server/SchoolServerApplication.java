package com.school_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class SchoolServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolServerApplication.class, args);
	}

}

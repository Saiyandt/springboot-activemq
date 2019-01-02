package com.example.rsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class RsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsserviceApplication.class, args);
	}

}


package com.project.dvdrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = "file:application.properties")
public class DvdrentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdrentalApplication.class, args);
	}

}

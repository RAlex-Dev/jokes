package com.roshan.jokes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
Roshan Alexander
Baldwin Assessment
 */

@SpringBootApplication
public class JokesApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JokesApplication.class);
	}

	// Main entry point into application

	public static void main(String[] args) {
		SpringApplication.run(JokesApplication.class, args);
	}

}

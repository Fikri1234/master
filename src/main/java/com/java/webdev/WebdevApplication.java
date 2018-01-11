package com.java.webdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.java.webdev")
@EnableAutoConfiguration
public class WebdevApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebdevApplication.class, args);
	}
}

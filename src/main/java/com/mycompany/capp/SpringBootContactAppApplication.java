package com.mycompany.capp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mycompany.capp")
public class SpringBootContactAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootContactAppApplication.class, args);
	}
//TODO : bean can be declared if required
}

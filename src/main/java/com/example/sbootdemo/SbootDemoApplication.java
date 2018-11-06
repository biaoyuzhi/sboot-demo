package com.example.sbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootDemoApplication.class, args);
	}
}

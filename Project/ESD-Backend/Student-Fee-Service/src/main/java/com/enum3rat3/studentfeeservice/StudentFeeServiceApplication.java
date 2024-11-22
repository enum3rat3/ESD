package com.enum3rat3.studentfeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentFeeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentFeeServiceApplication.class, args);
	}
}

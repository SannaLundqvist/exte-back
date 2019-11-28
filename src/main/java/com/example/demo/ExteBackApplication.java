package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import se.hig.exte.model.Exam;

@SpringBootApplication
public class ExteBackApplication {

	public static void main(String[] args) {
		Exam exam = new Exam();
		System.out.println(exam.equals(new Exam()));
		SpringApplication.run(ExteBackApplication.class, args);
	}

}

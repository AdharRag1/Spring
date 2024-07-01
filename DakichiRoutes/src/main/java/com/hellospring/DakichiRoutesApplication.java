package com.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DakichiRoutesApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DakichiRoutesApplication.class, args);
		

}
	@RequestMapping("/")
	public String welcome() {
		return "Welcome!";
	}
	 @RequestMapping("/today")
     public String today() {
             return "Today you will find luck..";
     } @RequestMapping("/tomorrow")
     public String tomorrow() {
         return "Tomorrow, an opportunity will arise";
 }	

}

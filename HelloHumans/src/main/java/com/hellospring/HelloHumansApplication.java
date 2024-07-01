package com.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController

public class HelloHumansApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumansApplication.class, args);
	}

	
    @RequestMapping("/")
    public String Humain() {
        return "Hello Humain";
    }
    
    @GetMapping("/")
    public  String index(@RequestParam(value="name", required=false) String name	 ,
            @RequestParam(value = "last_Name",required=false) String last_Name  ) {
        return "You searched for: "+name +"  "+ last_Name;
    }
    @GetMapping("/repeat")
    public String Repeat(
            @RequestParam(value = "name",  required=false) String name,
            @RequestParam(value = "lastname",  required=false) String lastname,
            @RequestParam(value = "times", defaultValue = "1") int times) {
        String rep= name + "   " + lastname;
        return "you searched: "+rep.repeat(times);
 
	}}


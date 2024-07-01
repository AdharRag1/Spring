package com.hellospring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/hello")
	public String helloworld() {
		return "hello adhar";
	}
	@RequestMapping("/cool")
	public String cool () { 
        return "Hello World";

}
@RequestMapping("/search")
public String search(@RequestParam(value="q") String searchQuery) {
return "you searched for "+ searchQuery;
	}
@RequestMapping("/sayhello/{name}/{lambada}")
public String sayHello(@PathVariable("name") String username, @PathVariable("lambada") String lambada) {
	return "Hello " + username + " "+lambada;
	
	}
}


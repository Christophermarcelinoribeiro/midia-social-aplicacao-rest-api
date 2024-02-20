package com.christopher.rest.webservices.restfulwebservices.helloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	@GetMapping(path = "/hello-word")
	public String helloWord() {
		return "hellow word";
	}
	@GetMapping(path = "/hello-word-bean")
	public HelloWordBean helloWordBean() {
		return new HelloWordBean("hellow word");
	}
	@GetMapping(path = "/hello-word/path variable/{name}")
	public HelloWordBean helloWordBean(@PathVariable String name) {
		return new HelloWordBean(String.format("hello word, %s", name));
	}
}

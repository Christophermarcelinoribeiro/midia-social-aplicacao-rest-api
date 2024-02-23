package com.christopher.rest.webservices.restfulwebservices.helloword;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	private MessageSource messagesource;

	public HelloWordController(MessageSource messagesource) {
		this.messagesource = messagesource;
	}
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
	@GetMapping(path = "/hello-word-internationalized")
	public String helloWordInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messagesource.getMessage("good.morning.message", null,"Default message", locale);
		//return "hellow word";
	}
}

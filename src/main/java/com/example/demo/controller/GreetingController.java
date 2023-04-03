package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Greeting;
import com.example.demo.service.GreetingService;

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService greetingService;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/greetings")
	public Greeting saveGreeting(@RequestBody Greeting greeting) {
		return greetingService.saveGreeting(greeting) ;
	}
	
	@GetMapping("/greetings")
	public List<Greeting> fetchGreetingList(){
		return greetingService.fetchGreetingList();
	}
	
	@PutMapping("/greetings/{id}")
	public Greeting updateGreeting(@RequestBody Greeting greeting, @PathVariable("id")Long greetingId) {
		return greetingService.updateGreeting(greeting, greetingId);
	}
	
	@DeleteMapping("/greetings/{id}")
	public String deleteGreetingById(@PathVariable("id")Long greetingId) {
		greetingService.deleteGreetingById(greetingId);
		return "Deleted Successfully";
	}
}

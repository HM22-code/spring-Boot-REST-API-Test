package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Greeting;

public interface GreetingService {
	
	Greeting saveGreeting(Greeting greeting);
	
	List<Greeting> fetchGreetingList();
	
	Greeting updateGreeting(Greeting greeting, Long greetingId);
	
	void deleteGreetingById(Long greetingId);

}

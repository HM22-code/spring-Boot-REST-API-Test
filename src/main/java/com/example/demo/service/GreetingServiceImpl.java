package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Greeting;
import com.example.demo.repository.GreetingRepository;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	private GreetingRepository greetingRepository;
	
	@Override
	public Greeting saveGreeting(Greeting greeting) {
		return greetingRepository.save(greeting);
	}

	@Override
	public List<Greeting> fetchGreetingList() {
		return (List<Greeting>) greetingRepository.findAll();
	}

	@Override
	public Greeting updateGreeting(Greeting greeting, Long greetingId) {
		Greeting gg = greetingRepository.findById(greetingId).get();
		
		if(Objects.nonNull(greeting.getContent())&& !"".equalsIgnoreCase(greeting.getContent())) {
			gg.setContent(greeting.getContent());
		}
		
		return greetingRepository.save(gg);
	}

	@Override
	public void deleteGreetingById(Long greetingId) {
		greetingRepository.deleteById(greetingId);
	}

}

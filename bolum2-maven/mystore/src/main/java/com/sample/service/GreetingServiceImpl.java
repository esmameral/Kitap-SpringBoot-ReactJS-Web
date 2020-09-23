package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.repository.GreetingMessageRepository;
@Service
public class GreetingServiceImpl implements GreetingService {
	@Autowired
	@Qualifier("greetingMessageRepositoryTr")
	private GreetingMessageRepository greetingMessage;
	
	@Override
	public String sayGreeting() {
		return greetingMessage.getMessage();
	}
}

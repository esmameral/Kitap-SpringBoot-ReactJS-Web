package com.sample.repository;

import org.springframework.stereotype.Repository;

@Repository("greetingMessageRepositoryEn")
public class GreetingMessageRepositoryEnImpl implements GreetingMessageRepository {

	@Override
	public String getMessage() {
		return "Hello friend!";
	}
}

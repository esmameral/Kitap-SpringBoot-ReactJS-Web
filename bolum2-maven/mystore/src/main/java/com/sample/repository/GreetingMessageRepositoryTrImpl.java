package com.sample.repository;

import org.springframework.stereotype.Repository;

@Repository("greetingMessageRepositoryTr")
public class GreetingMessageRepositoryTrImpl implements GreetingMessageRepository {

	@Override
	public String getMessage() {
		return "Merhaba arkadas";
	}

}

package com.sample.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("greetingMessageRepositoryEn")
@Lazy
public class GreetingMessageRepositoryEnImpl implements GreetingMessageRepository {

	@Override
	public String getMessage() {
		return "Hello friend!";
	}
}

package com.sample.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("greetingMessageRepositoryTr")
@Lazy
public class GreetingMessageRepositoryTrImpl implements GreetingMessageRepository {

	@Override
	public String getMessage() {
		return "Merhaba arkadas";
	}

}

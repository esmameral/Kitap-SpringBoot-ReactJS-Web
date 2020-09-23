package com.sample.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.AppConfig;
import com.sample.service.GreetingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestGreetingService {

	@Autowired
	private GreetingService greetingService;

	@Test
	public void test() {
		String message = greetingService.sayGreeting();
		assertNotNull(message);
		assertTrue(message.length() != 0);
		System.out.println(message);
		

	}

}

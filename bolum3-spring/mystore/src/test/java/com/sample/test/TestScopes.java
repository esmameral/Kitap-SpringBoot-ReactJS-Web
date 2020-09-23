package com.sample.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.AppConfig;
import com.sample.service.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestScopes {

	@Autowired
	Student studentA;
	@Autowired
	Student studentB;

	@Test
	public void test() {
		System.out.println("StudentA.name="+studentA.getName());
		System.out.println("StudentB.name="+studentB.getName());
		studentA.setName("meral");
		System.out.println("StudentA.name="+studentA.getName());
		System.out.println("StudentB.name="+studentB.getName());
	}

}

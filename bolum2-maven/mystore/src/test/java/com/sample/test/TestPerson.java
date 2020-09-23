package com.sample.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sample.model.Person;

public class TestPerson {
	@Test
	public void test() {
		Person p=new Person("esma");
		assertEquals(p.getName(), "esma");
		System.out.println();
		
	}
}
